package com.easybyte.accounts.service.impl;

import com.easybyte.accounts.constants.AccountsConstants;
import com.easybyte.accounts.dto.AccountsDto;
import com.easybyte.accounts.dto.CustomerDto;
import com.easybyte.accounts.entity.Accounts;
import com.easybyte.accounts.entity.Customer;
import com.easybyte.accounts.exception.CustomerAlreadyExistsException;
import com.easybyte.accounts.exception.ResourceNotFoundException;
import com.easybyte.accounts.mapper.AccountsMapper;
import com.easybyte.accounts.mapper.CustomerMapper;
import com.easybyte.accounts.repository.AccountRepository;
import com.easybyte.accounts.repository.CustomerRepository;
import com.easybyte.accounts.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerdto) {
        Customer customer = CustomerMapper.mapToCustomer(customerdto, new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(String.format("Customer already registered with given mobile number %s.",
                    customer.getMobileNumber()));
        }

        //TODO: Set createdAt to the current timestamp
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");

        Customer customerSaved = customerRepository.save(customer);
        accountRepository.save(createNewAccount(customerSaved));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());

        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);

        //TODO: Set createdAt to the current timestamp
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");

        return newAccount;
    }


    @Override
    public CustomerDto fetchAccountDetails(String phoneNumber) {

        Customer customer = customerRepository.findByMobileNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", phoneNumber)
        );

        Accounts account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", String.valueOf(customer.getCustomerId()))
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDo(customer, new CustomerDto());
        customerDto.setAccounts(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {

        AccountsDto accountsDto = customerDto.getAccounts();

        Accounts accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
        );

        AccountsMapper.mapToAccounts(accountsDto, accounts);
        accountRepository.save(accounts);

        Long customerId = accounts.getCustomerId();

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString())
        );

        CustomerMapper.mapToCustomer(customerDto, customer);
        customerRepository.save(customer);

        return true;
    }

    @Override
    public boolean deleteAccount(String phoneNumber) {

        Customer customer = customerRepository.findByMobileNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Phone Number", phoneNumber.toString())
        );

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
