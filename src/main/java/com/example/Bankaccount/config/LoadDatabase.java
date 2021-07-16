package com.example.Bankaccount.config;

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
            log.info("Preloading " + userAccountRepository.save(new UserAccount(1L,"Jan", "Kowalski", 1235L, new BigDecimal("10000.00"), 25)));
            log.info("Preloading " + userAccountRepository.save(new UserAccount(2L, "Adam", "Nowak", 4567L, new BigDecimal("12000.00"), 35)));

        };
    }
}
