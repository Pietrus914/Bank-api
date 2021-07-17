package com.example.Bankaccount.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserToYoungErrorController {
    @ResponseBody
    @ExceptionHandler(UserToYoungException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String userToYoungHandler(UserToYoungException e) {
        return e.getMessage();
    }
}
