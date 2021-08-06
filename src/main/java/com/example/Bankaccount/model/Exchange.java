package com.example.Bankaccount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
@ApiModel(description = "Transfer information")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(required = true, value = "Output account identifier")
    private Long id;
    @ApiModelProperty(required = true, value = "Amount to transfer")
    private double amount;
    @ApiModelProperty(required = true, value = "Target account identifier")
    private Long accountId;

    public Exchange() {
    }

    public Exchange(Long id, double amount, Long accountId) {
        this.id = id;
        this.amount = amount;
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
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
