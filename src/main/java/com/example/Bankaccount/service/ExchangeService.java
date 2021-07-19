package com.example.Bankaccount.service;

import com.example.Bankaccount.model.Exchange;
import com.example.Bankaccount.model.UserAccount;

public interface ExchangeService {

    Exchange transactionPln(Exchange exchange);
    Exchange transactionUsd(Exchange exchange);

}
