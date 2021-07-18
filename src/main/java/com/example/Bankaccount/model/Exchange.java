package com.example.Bankaccount.model;

import javax.persistence.*;

@Entity
@Table
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private Long accountId;

    public Exchange() {
    }

    public Exchange(Long id, double amount, Long accountId) {
        this.id = id;
        this.amount = amount;
        this.accountId = accountId;

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange that = (Exchange) o;

        if (amount != that.amount) return false;
        if (!id.equals(that.id)) return false;
        return accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + accountId.hashCode();
        result = (int) (31 * result + amount);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
