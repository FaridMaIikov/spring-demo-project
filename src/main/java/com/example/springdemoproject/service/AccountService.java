package com.example.springdemoproject.service;

import com.example.springdemoproject.dto.AccountDto;
import com.example.springdemoproject.dto.AccountDtoConverter;
import com.example.springdemoproject.dto.CreateAccountRequest;
import com.example.springdemoproject.model.Account;
import com.example.springdemoproject.model.Customer;
import com.example.springdemoproject.model.Transaction;
import com.example.springdemoproject.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.customerId());


        Account account = new Account(customer,
                createAccountRequest.initialCredit());

        customer.addAccount(account);

        if (createAccountRequest.initialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.initialCredit());
            account.addTransaction(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }
}
