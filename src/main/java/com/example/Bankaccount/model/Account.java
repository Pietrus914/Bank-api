package com.example.Bankaccount.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer accountNumber;
    private BigDecimal balance;
    private Type type;

    public Account() {
    }

    public Account(Long id, Integer accountNumber, BigDecimal balance, Type type) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Account {" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }
}
