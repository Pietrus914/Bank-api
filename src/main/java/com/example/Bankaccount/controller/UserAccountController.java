package com.example.Bankaccount.controller;


import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import com.example.Bankaccount.service.UserAccountServiceInterface;
import com.example.Bankaccount.util.exception.PageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserAccountServiceInterface userAccountServiceInterface;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @GetMapping("/users")
    List<UserAccount> all() {
        return userAccountRepository.findAll();
    }

        @PostMapping("/users")
    UserAccount newUserAccount(@RequestBody UserAccount newUserAccount) {
        return userAccountServiceInterface.createUserAccount(newUserAccount);
    }


    @GetMapping("/users/{id}")
    UserAccount singleUserAccount(@PathVariable Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new PageNotFoundException(id));
    }


    @PutMapping("/users/{id}")
    UserAccount replaceUserAccount(@RequestBody UserAccount newUserAccount, @PathVariable Long id) {

        return userAccountRepository.findById(id)
                .map(userAccount -> {
                    userAccount.setName(newUserAccount.getName());
                    userAccount.setLastName(newUserAccount.getLastName());
                    userAccount.setPersonalId(newUserAccount.getPersonalId());
                    userAccount.setPlnValue(newUserAccount.getPlnValue());
                    userAccount.setAge(newUserAccount.getAge());
                    return userAccountRepository.save(userAccount);
                })
                .orElseGet(() -> {
                    newUserAccount.setId(id);
                    return userAccountRepository.save(newUserAccount);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUserAccount(@PathVariable Long id) {
        userAccountRepository.deleteById(id);
    }
}
