package com.example.Bankaccount;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.AccountRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import com.example.Bankaccount.service.UserAccountService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BankAccountApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountService userAccountService;

    private Long testId = Long.valueOf(1);
    private String testName = "username";
    private String testLastName = "userlastname";
    private Integer testAge = 20;
    private Long testPersonalId = Long.valueOf(55555);
    private int testAccountNumber = 123456789;
    private BigDecimal testPlnValue = BigDecimal.valueOf(0.0);
    private double amount = 5.0;

    @After
    public void after() {
        userAccountRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    public void isPersonalIdExists() {
        UserAccount userAccount = new UserAccount(testId, testName,testLastName, testPersonalId, testAccountNumber, testPlnValue, testAge, null );
        userAccount.setPersonalId(testPersonalId);
        userAccountRepository.save(userAccount);
        assertNotNull(userAccountRepository.findByPersonalId(testPersonalId));
        assertEquals(testPersonalId, userAccountRepository.findByPersonalId(testPersonalId).getPersonalId());
    }

    @Test
    public void isAccountExists() {
        Account account = new Account(1L, testAccountNumber, testPlnValue, null);
        accountRepository.save(account);
        assertNotNull(accountRepository.findByAccountNumber(testAccountNumber));
        assertEquals(account.getAccountNumber(), accountRepository.findByAccountNumber(testAccountNumber).getAccountNumber());
    }

}
