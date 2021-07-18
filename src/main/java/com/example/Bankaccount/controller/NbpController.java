package com.example.Bankaccount.controller;

import com.example.Bankaccount.model.NbpResponse;
import com.example.Bankaccount.service.NbpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NbpController {

    private final NbpService nbpService;


    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/info")
    public NbpResponse getInfo(){
        return nbpService.getInfo();
    }
}
