package com.ruby.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruby.userservice.request.UserCreationRequestDTO;
import com.ruby.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserCreationRequestDTO userCreationRequest) throws ExecutionException, JsonProcessingException, InterruptedException {
        Long userId=userService.createUser(userCreationRequest);
        return ResponseEntity.ok(userId);

    }

}
