package com.example.Bankaccount.controller;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import com.example.Bankaccount.exception.PageNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
public class ExchangeController {

    private final UserAccountRepository userAccountRepository;
    private final AccountRepository accountRepository;

    public ExchangeController(UserAccountRepository userAccountRepository, AccountRepository accountRepository) {
        this.userAccountRepository = userAccountRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/transfer/{id}")
    UserAccount singleUserAccount(@PathVariable Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new PageNotFoundException(id));
    }

    @PutMapping("/transfer/{id}")
    UserAccount doTransaction(@RequestBody UserAccount newUserAccount, Account account, @PathVariable Long id) {

        userAccountRepository.findById(id).map(userAccount -> {
            userAccount.setPlnValue(newUserAccount.getPlnValue().add(new BigDecimal(88)));
//                    account.setBalance(account.getBalance().add(new BigDecimal(-88)));
            userAccountRepository.save(userAccount);
            return userAccountRepository.save(userAccount);
        });
        accountRepository.findById(id).map((acc -> {
            acc.setBalance(account.getBalance().add(new BigDecimal(-88)));
            return accountRepository.save(account);
        }));
        return userAccountRepository.save(newUserAccount);
    }


}
