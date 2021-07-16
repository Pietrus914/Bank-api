package com.example.Bankaccount.model;

import javax.persistence.*;

@Entity
@Table
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

//    @ManyToOne
//    private Account account;

    public Exchange() {
    }

    public Exchange(Long id, double amount, Account account) {
        this.id = id;
        this.amount = amount;
//        this.account = account;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
