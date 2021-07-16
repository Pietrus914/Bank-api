package com.example.Bankaccount.model;

import com.example.Bankaccount.config.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer accountNumber;
    private BigDecimal balance;
    private Type type;

//    @OneToMany(mappedBy = "usdAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List <Exchange> exchangesList = new ArrayList<>();

    public Account() {
    }

    public Account(Long id, Integer accountNumber, BigDecimal balance, Type type) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
//        this.exchangesList = Collections.emptyList();
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal  balance) {
        this.balance = balance;
    }

//    public List<Exchange> getExchangesList() {
//        return exchangesList;
//    }
//
//    public void setExchangesList(List<Exchange> exchangesList) {
//        this.exchangesList = exchangesList;
//    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account {" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
//                ", transactionList=" + exchangesList +
                '}';
    }
}
