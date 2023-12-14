package com.easybyte.accounts.service.impl;

import com.easybyte.accounts.constants.AccountsConstants;
import com.easybyte.accounts.dto.CustomerDto;
import com.easybyte.accounts.entity.Accounts;
import com.easybyte.accounts.entity.Customer;
import com.easybyte.accounts.exception.CustomerAlreadyExistsException;
import com.easybyte.accounts.mapper.CustomerMapper;
import com.easybyte.accounts.repository.AccountRepository;
import com.easybyte.accounts.repository.CustomerRepository;
import com.easybyte.accounts.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(String.format("Customer already registered with given mobile number %s.",
                    customer.getMobileNumber()));
        }

        Customer CustomerSaved = customerRepository.save(customer);
        accountRepository.save(createNewAccount(CustomerSaved));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());

        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
