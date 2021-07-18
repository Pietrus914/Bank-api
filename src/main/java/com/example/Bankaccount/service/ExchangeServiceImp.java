package com.example.Bankaccount.service;


import com.example.Bankaccount.model.Exchange;
import com.example.Bankaccount.repository.ExchangeRepository;
import com.example.Bankaccount.repository.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ExchangeServiceImp implements ExchangeService{



    private ExchangeRepository exchangeRepository;

    private static final Logger logger = LoggerFactory.getLogger(ExchangeService.class);

    @Override
    public Exchange transaction(Exchange exchange) {
        try {
        Optional<Exchange> transfer = exchangeRepository.findById(exchange.getId());


            if (transfer == null) {
                logger.info("Transaction impossible.", exchange.getId());
            } else {
                Exchange newTransfer = new Exchange();
                newTransfer.setAmount(50);
                newTransfer.setAccountId(1L);
                exchangeRepository.save(newTransfer);

                System.out.println(newTransfer);
            }

        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");

        }
        return exchange;
    }

}
