package com.example.Bankaccount.controller;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.util.exception.PageNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account")
    List<Account> all(){
        return accountRepository.findAll();
    }

    @PostMapping("/account")
    Account newAccount(@RequestBody Account newAccount){
        return accountRepository.save(newAccount);
    }


    @GetMapping("/account/{id}")
    Account singleUsdAccount(@PathVariable Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new PageNotFoundException(id));
    }


}
