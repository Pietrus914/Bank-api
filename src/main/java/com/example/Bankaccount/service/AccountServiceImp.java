package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Type;
import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository, UserAccountService userAccountService) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount( ) {
        Account account = new Account();
        account.setAccountNumber(new Random().nextInt());
        account.setBalance(new BigDecimal("0.0"));
        account.setType(Type.USD_ACCOUNT);
        accountRepository.save(account);

        System.out.println(account);

        return accountRepository.findByAccountNumber(account.getAccountNumber());
    }



}


