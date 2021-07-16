package com.example.Bankaccount.repository;

import com.example.Bankaccount.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<UserAccount, Long> {
}
