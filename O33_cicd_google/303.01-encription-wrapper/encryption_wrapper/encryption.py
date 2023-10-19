#!/usr/bin/env python3

from tink import cleartext_keyset_handle
from typing import BinaryIO

from tink import JsonKeysetWriter
from tink import tink_config
from tink import streaming_aead
from tink.integration import gcpkms
from tink.core import TinkError
from tink import aead
import tink
from encryption_wrapper.common import error_and_exit
import os
import io
import shutil
import stat
import logging


logging.basicConfig(level='INFO')


_TMP_LOCATION = os.getenv('GSUTIL_TMP_LOCATION',
                          os.path.expanduser('~') + '/.gsutil-wrapper/')
BLOCK_SIZE = 1024 * 1024  # The CLI tool will read/write at most 1 MB at once.
associated_data = b'PASSWORD' 

class EncryptWithTink(object):
    """Perform local encryption and decryption with Tink."""

    def __init__(self, key_uri, creds, tmp_location=_TMP_LOCATION):

        self.tmp_location = tmp_location
        # Make the tmp dir if it doesn't exist
        if not os.path.isdir(self.tmp_location):
            # noinspection PyUnusedLocal
            try:
                os.makedirs(self.tmp_location)
            except FileExistsError:
                # This is ok because the directory already exists
                pass
            except OSError as os_error:
                error_and_exit(str(os_error))

        # Initialize Tink
        try:
            aead.register()
            tink_config.register()
            streaming_aead.register()

            print(">>>>>>key_uri:", key_uri)
            print(">>>>>>creds:", creds)

            self.key_template = aead.aead_key_templates.AES256_EAX
            self.keyset_handle = tink.new_keyset_handle(self.key_template)

            gcp_client = gcpkms.GcpKmsClient(key_uri, creds)
            gcp_aead = gcp_client.get_aead(key_uri)
            self.env_aead = aead.KmsEnvelopeAead(self.key_template, gcp_aead)

            # 1. Generate the key material.
            # self.stream_keyset_handle = tink.new_keyset_handle(
            #     streaming_aead.streaming_aead_key_templates.AES256_CTR_HMAC_SHA256_1MB)
            # 2. Get the primitive.
            # self.streaming_aead_primitive = self.stream_keyset_handle.primitive(streaming_aead.StreamingAead)

            self.stream_keyset_handle = self.generate_gcp_keyset_handle(key_uri, creds)

              # Get the primitive.
            try:
                self.streaming_aead_primitive = self.stream_keyset_handle.primitive(
                    streaming_aead.StreamingAead)
            except tink.TinkError as e:
                error_and_exit('Error creating streaming AEAD primitive from keyset: %s',e)
                

            

            # gcp_streaming_aead = gcp_client.register_client()
            # self.env_streaming_aead = streaming_aead.KmsEnvelopeStreamingAead(self.stream_key_template, gcp_streaming_aead)

        except TinkError as tink_init_error:
            error_and_exit('tink initialization failed: ' +
                           str(tink_init_error))


    def encrypt(self, filepath):
        print(">>>>>>>>>>> EncryptWithTink: encrypt: ", filepath)
        if os.path.isdir(filepath):
            error_and_exit('cannot encrypt a directory')
        elif stat.S_ISFIFO(os.stat(filepath).st_mode):
            error_and_exit('cannot encrypt a FIFO')

        filename = os.path.basename(filepath)
        encrypted_filepath = self.tmp_location + '/' + filename
        try:
            shutil.copyfile(filepath, encrypted_filepath)
        except OSError as copy_error:
            error_and_exit("EXCEPTION COPY", str(copy_error))

        try:
            with open(filepath, 'rb') as f:
                plaintext = f.read()
            ciphertext = self.env_aead.encrypt(plaintext, b'')
            with open(encrypted_filepath, 'wb') as f:
                f.write(ciphertext)
        except TinkError as encryption_error:
            error_and_exit("encryption_error", str(encryption_error))

        print(">>>>>>>>>>> DONE EncryptWithTink: filepath: ", filepath)

        return encrypted_filepath


    def decrypt(self, filepath):
        filename = os.path.basename(filepath)
        decrypted_filepath = self.tmp_location + '/' + filename

        try:
            with open(filepath, 'rb') as f:
                ciphertext = f.read()
            cleartext = self.env_aead.decrypt(ciphertext, b'')
            with open(decrypted_filepath, 'wb') as f:
                f.write(cleartext)
            shutil.copyfile(decrypted_filepath, filepath)
            os.unlink(decrypted_filepath)
        except TinkError as decryption_error:
            error_and_exit(str(decryption_error))

        return decrypted_filepath

    
    def stream_encrypt(self, filepath):
        print(">>>>>>>>>>> EncryptWithTink: stream encrypt: ", filepath)
        if os.path.isdir(filepath):
            error_and_exit('cannot encrypt a directory')
        elif stat.S_ISFIFO(os.stat(filepath).st_mode):
            error_and_exit('cannot encrypt a FIFO')

        filename = os.path.basename(filepath)
        encrypted_filepath = self.tmp_location + '/' +  'stream_' + filename
        try:
            shutil.copyfile(filepath, encrypted_filepath)
        except OSError as copy_error:
            error_and_exit("EXCEPTION COPY", str(copy_error))

        try:
            with open(filepath, 'rb') as input_file:
                with open(encrypted_filepath, 'wb') as output_file:
                    self.stream_encrypt_file(input_file, output_file, associated_data, self.streaming_aead_primitive)

        except TinkError as encryption_error:
            error_and_exit("encryption_error", str(encryption_error))
        return encrypted_filepath


    def generate_gcp_keyset_handle(self, key_uri, creds):
        print(">>>>>>>>>>> generate_gcp_keyset_handle: ", key_uri, "creds: ", creds)

        # Read the GCP credentials and setup client
        gcpkms.GcpKmsClient.register_client(key_uri, creds)
        handle = tink.new_keyset_handle(aead.aead_key_templates.create_kms_aead_key_template(key_uri))
        gcp_aead = handle.primitive(aead.Aead)

        keyset_handle = tink.new_keyset_handle(streaming_aead.streaming_aead_key_templates.AES256_CTR_HMAC_SHA256_1MB)

        string_out = io.StringIO()
        writer = JsonKeysetWriter(string_out)
        cleartext_keyset_handle.write(writer, keyset_handle)

        keyset_handle.write(writer, gcp_aead)
        
        return keyset_handle


    def read_as_blocks(self, file: BinaryIO):
        """Generator function to read from a file BLOCK_SIZE bytes.

        Args:
            file: The file object to read from.

        Yields:
            Returns up to BLOCK_SIZE bytes from the file.
        """
        while True:
            data = file.read(BLOCK_SIZE)
            # If file was opened in rawIO, EOF is only reached when b'' is returned.
            # pylint: disable=g-explicit-bool-comparison
            if data == b'':
                break
            # pylint: enable=g-explicit-bool-comparison
            yield data
    
    def stream_encrypt_file(self, input_file: BinaryIO, output_file: BinaryIO,
                 associated_data: bytes,
                 primitive: streaming_aead.StreamingAead):
        """Encrypts a file with the given streaming AEAD primitive.

        Args:
            input_file: File to read from.
            output_file: File to write to.
            associated_data: Associated data provided for the AEAD.
            primitive: The streaming AEAD primitive used for encryption.
        """
        print(">>>>>>>>>>> stream_encrypt_file: input_file: ", input_file)
        print(">>>>>>>>>>> stream_encrypt_file: output_file: ", output_file)
        print(">>>>>>>>>>> stream_encrypt_file: associated_data: ", associated_data)

        with primitive.new_encrypting_stream(output_file,
                                            associated_data) as enc_stream:
            for data_block in self.read_as_blocks(input_file):
                enc_stream.write(data_block)

