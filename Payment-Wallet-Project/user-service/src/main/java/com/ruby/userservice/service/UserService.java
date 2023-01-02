package com.ruby.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruby.userservice.entity.UserEntity;
import com.ruby.userservice.repos.UserRepo;
import com.ruby.userservice.request.UserCreationRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ObjectMapper objectMapper;

    private String topic="USER_CREATED";

    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public Long createUser(UserCreationRequestDTO userCreationRequestDTO) throws JsonProcessingException, ExecutionException, InterruptedException {
       UserEntity user= UserEntity.builder().email(userCreationRequestDTO.getEmail())
                .phone(userCreationRequestDTO.getPhone())
                .name(userCreationRequestDTO.getName())
                .kycId(userCreationRequestDTO.getKycId())
                .build();
       userRepo.save(user);
        Map<String,Object> payload=new HashMap<>();
        payload.put("userId",user.getId());
        payload.put("email",user.getEmail());
        payload.put("name",user.getName());


        ListenableFuture<SendResult<String, String>> listenableFuture= kafkaTemplate.send(topic, String.valueOf(user.getId()),objectMapper.writeValueAsString(payload));
        logger.info("Pushed in {} kafka response:{}",topic,listenableFuture.get());
       return user.getId();
    }

}
