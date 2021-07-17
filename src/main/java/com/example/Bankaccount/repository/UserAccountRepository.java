package com.example.Bankaccount.repository;

import com.example.Bankaccount.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByPersonalId(Long personalId);

}
