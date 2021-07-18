package com.example.Bankaccount.model;


import lombok.Data;

import javax.persistence.Entity;
import java.util.List;


@Data
public class NbpResponse {

    private String currency;


    public NbpResponse(String currency) {
        this.currency = currency;

    }


}
