package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService implements UserAccountServiceInterface {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AccountServiceInterface accountServiceInterface;

    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceInterface.class);

    @Override
    public UserAccount findByPersonalId(Long personalId) {
        return userAccountRepository.findByPersonalId(personalId);
    }

    @Override
    public boolean checkUserAccountExist(Long personalId) {
        return checkPersonalIdExist(personalId);
    }

    @Override
    public boolean checkPersonalIdExist(Long personalId) {
        return null != findByPersonalId(personalId);
    }


    public UserAccount createUserAccount(UserAccount userAccount) {

        UserAccount newUserAccount = userAccountRepository.findByPersonalId(userAccount.getPersonalId());
        System.out.println(userAccountRepository.findByPersonalId(userAccount.getPersonalId()));
        try {
            if (newUserAccount != null) {
                logger.info("UserAccount with personalId {} already exist.", userAccount.getPersonalId());
            } else {
                newUserAccount.setAccount(accountServiceInterface.createAccount());
                userAccountRepository.save(userAccount);
            }
        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");

        }

        return userAccount;
    }
}
