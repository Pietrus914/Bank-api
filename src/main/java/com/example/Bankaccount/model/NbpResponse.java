package com.example.Bankaccount.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;


@Data
public class NbpResponse {

    @JsonProperty("code")
    private String currency;

    @JsonProperty("rates")
    private JsonNode rates;


}
