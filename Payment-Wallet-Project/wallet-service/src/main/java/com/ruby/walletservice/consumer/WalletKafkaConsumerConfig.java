package com.ruby.walletservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruby.walletservice.entity.Wallet;
import com.ruby.walletservice.exception.InsuficientBalanceException;
import com.ruby.walletservice.repos.WalletRepo;
import com.ruby.walletservice.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@EnableKafka
@Configuration
public class WalletKafkaConsumerConfig {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    WalletService walletService;

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private String transactiontopic="TRANSACTION_COMPLETED";

    static Logger logger= LoggerFactory.getLogger(WalletKafkaConsumerConfig.class);

    @KafkaListener(topics = "USER_CREATED",groupId = "wallet-service")
    public void listenUserCreatedTopic(String message) throws JsonProcessingException {
        logger.info("Consuming : {}", message);
        Map<String,Object> payload=objectMapper.readValue(message,Map.class);
        Wallet wallet= Wallet.builder().userId(Long.valueOf(payload.get("userId").toString()))
                .email(String.valueOf(payload.get("email")))
                .balance(100.00)
                .build();
        walletRepo.save(wallet);


    }


    @KafkaListener(topics = "TRANSACTION_INIT",groupId = "wallet-service")
    public void listenTransactionInitTopic(String message) throws JsonProcessingException, ExecutionException, InterruptedException {
        logger.info("Consuming : {}", message);
        Map<String,Object> payload=objectMapper.readValue(message,Map.class);

        Long senderId= Long.valueOf((Integer)payload.get("fromUserId"));
        Long receiverId=Long.valueOf((Integer)payload.get("toUserId"));
        Double amount=Double.valueOf(payload.get("amount").toString());
        Map<String,Object> map=new HashMap<>();
        map.put("transactionId",payload.get("id"));
        try {
            walletService.updateWalletForTransaction(senderId, receiverId, amount);
            map.put("status","SUCESSFULL");
        }
        catch (InsuficientBalanceException e) {
            logger.error("Exception while updating wallt {}",e);
            map.put("status","FAILED");

        }
        String txnpayload=objectMapper.writeValueAsString(map);
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(transactiontopic, String.valueOf(senderId),txnpayload);
        logger.info("Pushed to topic: {}, kafka response: {}",transactiontopic,listenableFuture.get());


    }


}
