package com.example.Bankaccount.service;

import com.example.Bankaccount.model.UserAccount;

public interface UserAccountServiceInterface {

    UserAccount findByPersonalId(Long personalId);

    boolean checkUserAccountExist(Long personalId);
    boolean checkPersonalIdExist(Long personalId);
    UserAccount createUserAccount(UserAccount userAccount);
}
