package com.example.Bankaccount.util.exception;

public class PageNotFoundException extends  RuntimeException{

    public PageNotFoundException(Long id) {
        super("Could not found user/account with id:  " + id);
    }
}
