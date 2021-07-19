package com.example.Bankaccount.client;


import com.example.Bankaccount.model.NbpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class NbpClient {

    public NbpResponse getNbpInfo(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today/";
        ResponseEntity<NbpResponse> response = restTemplate.getForEntity(url, NbpResponse.class);

        log.info(response.getStatusCode().toString());
        NbpResponse bodyResponse = response.getBody();
        log.info(bodyResponse.toString());
        return bodyResponse;
    }
}
