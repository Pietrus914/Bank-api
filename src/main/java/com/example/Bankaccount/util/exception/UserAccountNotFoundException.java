package com.example.Bankaccount.util.exception;

public class UserAccountNotFoundException extends  RuntimeException{
    public UserAccountNotFoundException(Long id) {
        super("Could not find user account number:  " + id);
    }

}
