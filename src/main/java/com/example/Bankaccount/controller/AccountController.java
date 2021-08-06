package com.example.Bankaccount.controller;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.exception.PageNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @ApiOperation("Operation to list all accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Powodzenie / Success", response = Account.class),
            @ApiResponse(code = 400, message = "Błędne żądanie / Bad request", response = Error.class)})
    @GetMapping("/account")
    List<Account> all(){
        return accountRepository.findAll();
    }

    @PostMapping("/account")
    Account newAccount(@RequestBody Account newAccount){
        return accountRepository.save(newAccount);
    }

    @GetMapping("/account/{id}")
    Account singleAccount(@PathVariable Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new PageNotFoundException(id));
    }


}
