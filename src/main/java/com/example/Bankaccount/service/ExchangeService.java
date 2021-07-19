package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Exchange;

public interface ExchangeService {

    Exchange transactionPln(Exchange exchange);
    Exchange transactionUsd(Exchange exchange);

}
