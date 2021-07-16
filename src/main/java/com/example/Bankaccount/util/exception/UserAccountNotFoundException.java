package com.example.Bankaccount.util.exception;

public class UserAccountNotFoundException extends  RuntimeException{
    public UserAccountNotFoundException(Long id) {
        super("Could not found user account number:  " + id);
    }

}
