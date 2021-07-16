package com.example.Bankaccount.util.exception;

public class AccountNotFoundException extends  RuntimeException{
    public AccountNotFoundException(Long id) {
        super("Could not found account number:  " + id);
    }
}
