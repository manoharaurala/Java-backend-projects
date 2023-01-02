package com.ruby.transactionservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruby.transactionservice.entity.Transaction;
import com.ruby.transactionservice.enums.TransactionStatus;
import com.ruby.transactionservice.repos.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;

@EnableKafka
@Configuration
public class TransactionKafkaConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionRepo transactionRepo;



    static Logger logger= LoggerFactory.getLogger(TransactionKafkaConsumer.class);

    @KafkaListener(topics = "TRANSACTION_COMPLETED",groupId = "transaction-service")
    public void listenUserCreatedTopic(String message) throws JsonProcessingException {
        logger.info("Consuming : {}", message);
        Map<String,Object> payload=objectMapper.readValue(message,Map.class);
        Long txnId= Long.valueOf((Integer)payload.get("transactionId"));
        String status= (String) payload.get("status");
        Transaction transaction=transactionRepo.findById(txnId).get();
        transaction.setStatus(TransactionStatus.valueOf(status));
        transactionRepo.save(transaction);



    }



}
