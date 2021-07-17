package com.example.Bankaccount.service;

import com.example.Bankaccount.config.Type;
import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    private AccountRepository accountRepository;
    private UserAccountServiceInterface userAccountServiceInterface;
    private UserAccount userAccount;

    public AccountService(AccountRepository accountRepository, UserAccountServiceInterface userAccountServiceInterface) {
        this.accountRepository = accountRepository;
        this.userAccountServiceInterface = userAccountServiceInterface;
    }

    @Override
    public Account createAccount( ) {
        Account account = new Account();
        account.setId(userAccount.getId());
        account.setAccountNumber(new Random().nextInt());
        account.setBalance(new BigDecimal("0.0"));
        account.setType(Type.PLN_ACCOUNT);
        accountRepository.save(account);

        return accountRepository.findByAccountNumber(account.getAccountNumber());
    }


    @Override
    public void exchange(BigDecimal amount, UserAccount userAccount) {

    }
}


