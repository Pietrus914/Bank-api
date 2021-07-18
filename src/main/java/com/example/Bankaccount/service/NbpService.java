package com.example.Bankaccount.service;

import com.example.Bankaccount.client.NbpClient;
import com.example.Bankaccount.model.NbpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NbpService {

    private final NbpClient client;

    @Autowired
    public NbpService(NbpClient client){
        this.client = client;
    }

    public NbpResponse getInfo(){
        return client.getNbpInfo();
    }
}
