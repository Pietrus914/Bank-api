package com.example.Bankaccount.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class NbpClient {

    public String getNbpInfo(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        log.info(response.getStatusCode().toString());
        String bodyResponse = response.getBody();
        log.info(bodyResponse.toString());
        return bodyResponse;
    }
}
