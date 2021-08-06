package com.example.Bankaccount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table
@ApiModel(description = "Account base information")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true, value = "Identifier")
    private Long id;

    @ApiModelProperty(required = true, value = "Account number")
    private Integer accountNumber;
    @ApiModelProperty(required = true, value = "Account balance")
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
