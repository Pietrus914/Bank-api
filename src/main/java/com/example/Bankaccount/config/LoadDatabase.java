package com.example.Bankaccount.config;

import com.example.Bankaccount.model.Account;
import com.example.Bankaccount.model.UserAccount;
import com.example.Bankaccount.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserAccountRepository userAccountRepository) {

        return args -> {
            log.info("Preloading " + userAccountRepository.save(new UserAccount
                    (1L,"Jan", "Kowalski", 1235L, 555555, new BigDecimal("10000.00"), 25,
                            new Account(1L,100, new BigDecimal("1000.00"), Type.USD_ACCOUNT))));
                           ;
            log.info("Preloading " + userAccountRepository.save(new UserAccount
                    (2L, "Adam", "Nowak", 4567L, 666666, new BigDecimal("12000.00"), 35,
                            new Account(2L,300, new BigDecimal("1200.00"), Type.USD_ACCOUNT))));
        };
    }
}
