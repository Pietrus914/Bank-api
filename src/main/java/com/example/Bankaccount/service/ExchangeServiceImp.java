package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Exchange;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.repository.ExchangeRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeServiceImp implements ExchangeService {



    private ExchangeRepository exchangeRepository;

    private UserAccountRepository userAccountRepository;
    private AccountRepository accountRepository;

    public ExchangeServiceImp(ExchangeRepository exchangeRepository, UserAccountRepository userAccountRepository, AccountRepository accountRepository) {
        this.exchangeRepository = exchangeRepository;
        this.userAccountRepository = userAccountRepository;
        this.accountRepository = accountRepository;
    }

    public Exchange findUser(Long id){
        return exchangeRepository.getById(id);
    }

    public Optional<UserAccount> findAccount(Long id) {
        return userAccountRepository.findById(id);
    }



}
