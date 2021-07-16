package com.example.Bankaccount.util.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.security.auth.login.AccountNotFoundException;

@ControllerAdvice
public class AccountNotFoundErrorController {

    @ResponseBody
    @ExceptionHandler({UserAccountNotFoundException.class, AccountNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserAccountNotFoundException e){
        return e.getMessage();
    }
}
