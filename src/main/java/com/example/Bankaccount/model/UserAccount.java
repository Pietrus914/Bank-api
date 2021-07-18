package com.example.Bankaccount.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private Long personalId;
    private Integer plnAccountNumber;
    private BigDecimal plnValue;
    private Integer age;

    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pln_fk", referencedColumnName = "id")
    private Account account;

    public UserAccount() {
    }

    public UserAccount(Long id, String name, String lastName, Long personalId, Integer plnAccountNumber, BigDecimal plnValue, Integer age, Account account) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.plnAccountNumber = plnAccountNumber;
        this.plnValue = plnValue;
        this.age = age;
        this.account = account;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof UserAccount))
            return false;
        UserAccount userAccount = (UserAccount) o;
        return Objects.equals(this.id, userAccount.id)
                && Objects.equals(this.name, userAccount.name)
                && Objects.equals(this.lastName, userAccount.lastName)
                && Objects.equals(this.personalId, userAccount.personalId)
                && Objects.equals(this.plnAccountNumber, userAccount.plnAccountNumber)
                && Objects.equals(this.plnValue, userAccount.plnValue)
                && Objects.equals(this.age, userAccount.age)
                && Objects.equals(this.account, userAccount.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.lastName, this.personalId, this.plnAccountNumber, this.plnValue, this.age, this.account);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", last name='" + this.lastName + '\'' +
                ", personal ID='" + this.personalId + '\'' + ", pln account number=" + this.plnAccountNumber + '\''
                + ", pln value=" + this.plnValue + '\'' + ", age=" + this.age + '}';
    }
}
