package com.example.Bankaccount.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class NbpResponse {

    @JsonProperty("code")
    private String currency;

    @JsonProperty("rates")
    private List<Rate> rates;


}
