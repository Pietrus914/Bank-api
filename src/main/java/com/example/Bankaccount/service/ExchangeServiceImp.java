package com.example.Bankaccount.service;

import com.example.Bankaccount.client.NbpClient;
import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.Exchange;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.repository.ExchangeRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Slf4j
@Service
public class ExchangeServiceImp implements ExchangeService {


    private ExchangeRepository exchangeRepository;
    private UserAccountRepository userAccountRepository;
    private AccountRepository accountRepository;
    private NbpClient nbpClient;


    public ExchangeServiceImp(ExchangeRepository exchangeRepository, UserAccountRepository userAccountRepository, AccountRepository accountRepository, NbpClient nbpClient) {
        this.exchangeRepository = exchangeRepository;
        this.userAccountRepository = userAccountRepository;
        this.accountRepository = accountRepository;
        this.nbpClient = nbpClient;
    }

    @Override
    public Exchange transactionPln(Exchange exchange) {

        try {
            Optional<UserAccount> userAccount = userAccountRepository.findById(exchange.getAccountId());
            Optional<Account> account = accountRepository.findById(exchange.getAccountId());
            if (userAccount.isPresent()){
                exchangeRepository.save(exchange);
                BigDecimal usdRate = nbpClient.getNbpInfo().getRates().get(0).getAsk();
                userAccount.get().setPlnValue(userAccount.get().getPlnValue().subtract(BigDecimal.valueOf(exchange.getAmount())));
                userAccountRepository.save(userAccount.get());

                account.get().setBalance(account.get().getBalance().add(BigDecimal.valueOf(exchange.getAmount()).divide(usdRate, 2, RoundingMode.HALF_DOWN)));
                accountRepository.save(account.get());
            } else {
                log.info("UserAccount not exist.");
            }


        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");

        }
        return exchange;
    }

    @Override
    public Exchange transactionUsd(Exchange exchange) {

        try {
            Optional<UserAccount> userAccount = userAccountRepository.findById(exchange.getAccountId());
            Optional<Account> account = accountRepository.findById(exchange.getAccountId());
            if (userAccount.isPresent()){
                exchangeRepository.save(exchange);
                BigDecimal usdRate = nbpClient.getNbpInfo().getRates().get(0).getBid();

                account.get().setBalance(account.get().getBalance().subtract(BigDecimal.valueOf(exchange.getAmount())));
                accountRepository.save(account.get());

                userAccount.get().setPlnValue(userAccount.get().getPlnValue().add(BigDecimal.valueOf(exchange.getAmount()).multiply(usdRate)));
                userAccountRepository.save(userAccount.get());
            }else {
                log.info("UserAccount not exist.");
            }

        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");

        }
        return exchange;
    }

}
