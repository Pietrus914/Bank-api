package com.example.Bankaccount.repository;

import com.example.Bankaccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
