package com.ruby.notificationservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

@EnableKafka
@Configuration
public class NotificationKafkaConsumerConfig {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JavaMailSender javaMailSender;


    static Logger logger= LoggerFactory.getLogger(NotificationKafkaConsumerConfig.class);

    @KafkaListener(topics = "WALLET_UPDATED",groupId = "notification-email-service")
    public void sendWalletUpdateEmail(String message) throws JsonProcessingException {
        logger.info("Consuming : {}", message);
        Map<String,Object> payload=objectMapper.readValue(message,Map.class);
        logger.info("Data from WALLET_UPDATED topic: {}",payload);
        String email= (String) payload.get("email");
        Double balance= Double.valueOf(payload.get("balance").toString());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rubypaymentwallet@gmail.com");
        simpleMailMessage.setSubject("wallet Updated");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText("Your updated account balance is : "+balance);
      //  simpleMailMessage.setCc("<--cc:emailIds-->")

        javaMailSender.send(simpleMailMessage);

        logger.info("Email sent to{}",email);



    }



    @KafkaListener(topics = "USER_CREATED",groupId = "notification-email-service")
    public void sendWelcomeEmail(String message) throws JsonProcessingException {
        logger.info("Consuming : {}", message);
        Map<String,Object> payload=objectMapper.readValue(message,Map.class);
        logger.info("Data from USER_CREATED topic: {}",payload);
        String email= (String) payload.get("email");
        String name= (String) payload.get("name");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rubypaymentwallet@gmail.com");
        simpleMailMessage.setSubject("Welcome in Ruby Payment Wallet");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText("Hello "+name+", Your account is ready");
        //  simpleMailMessage.setCc("<--cc:emailIds-->")

        javaMailSender.send(simpleMailMessage);

        logger.info("Email sent to{}",email);



    }

}
