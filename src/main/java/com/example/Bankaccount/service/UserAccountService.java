package com.example.Bankaccount.service;

import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserAccountService implements UserAccountServiceInterface {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AccountServiceInterface accountServiceInterface;

    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceInterface.class);


    public UserAccount findByPersonalId(Long personalId) {
        return userAccountRepository.findByPersonalId(personalId);
    }


    public boolean checkUserAccountExist(Long personalId) {
        return checkPersonalIdExist(personalId);
    }


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
            logger.info("lipa.");
            UserAccount newUser = new UserAccount();
            newUser.setName("");
            newUser.setLastName("");
            newUser.setPersonalId(0000000l);
            newUser.setPlnValue(new BigDecimal(0.0));
            newUser.setAge(0);

            newUser.setAccount(accountServiceInterface.createAccount());
            userAccountRepository.save(newUser);

            System.out.println(newUser);
        }

        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");

        }
        return userAccount;
    }
}
