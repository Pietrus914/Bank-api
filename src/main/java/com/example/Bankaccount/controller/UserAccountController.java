package com.example.Bankaccount.controller;


import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.UserAccountRepository;
import com.example.Bankaccount.service.UserAccountService;
import com.example.Bankaccount.exception.PageNotFoundException;
import com.example.Bankaccount.exception.UserToYoungException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAccountController {


    private final UserAccountRepository userAccountRepository;
    private UserAccountService userAccountService;


    public UserAccountController(UserAccountRepository userAccountRepository, UserAccountService userAccountService) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountService = userAccountService;
    }

    @ApiOperation("Operation to list all users accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Powodzenie / Success", response = UserAccount.class),
            @ApiResponse(code = 400, message = "Błędne żądanie / Bad request", response = Error.class)})
    @GetMapping("/users")
    List<UserAccount> all() {
        return userAccountRepository.findAll();
    }


    @PostMapping("/users")
    UserAccount newUserAccount(@RequestBody UserAccount newUserAccount) {
        return userAccountService.createUserAccount(newUserAccount);
    }


    @GetMapping("/users/{id}")
    UserAccount singleUserAccount(@PathVariable Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new PageNotFoundException(id));
    }


    @GetMapping("/personal/{personalId}")
    Optional<UserAccount> singleUserAccountByPersonalId(@PathVariable Long personalId) {
        Optional<UserAccount> userAccountByPersonalId = Optional.ofNullable(userAccountRepository.findByPersonalId(personalId));
        userAccountByPersonalId.orElseThrow(() -> new PageNotFoundException(personalId));

        return userAccountByPersonalId;
    }


    @PutMapping("/users/{id}")
    UserAccount replaceUserAccount(@RequestBody UserAccount newUserAccount, @PathVariable Long id) {

        return userAccountRepository.findById(id)
                .map(userAccount -> {
                    userAccount.setName(newUserAccount.getName());
                    userAccount.setLastName(newUserAccount.getLastName());
                    userAccount.setPersonalId(newUserAccount.getPersonalId());
                    userAccount.setPlnAccountNumber(newUserAccount.getPlnAccountNumber());
                    userAccount.setPlnValue(newUserAccount.getPlnValue());
                    userAccount.setAge(newUserAccount.getAge());
                    if (newUserAccount.getAge() < 18) {
                        throw new UserToYoungException(id);
                    }
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
