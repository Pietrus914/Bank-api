package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;

import java.math.BigDecimal;

public interface AccountServiceInterface {

    Account createAccount();

    void exchange(BigDecimal amount, UserAccount userAccount);

}
