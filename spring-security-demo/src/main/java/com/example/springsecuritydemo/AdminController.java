package com.example.springsecuritydemo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin-api")
public class AdminController {


        @GetMapping("/hello")
        ResponseEntity<String> getHello(){
            return ResponseEntity.ok("hello admin");
        }
    }

