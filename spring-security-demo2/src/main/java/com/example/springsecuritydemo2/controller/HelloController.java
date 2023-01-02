package com.example.springsecuritydemo2.controller;

import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/user/hello")
    ResponseEntity<String> getHello(){

        return ResponseEntity.ok("hello user!: "+ MDC.get("username"));
    }

    @GetMapping("/admin/hello")
    ResponseEntity<String> getHelloAdmin(){
        return ResponseEntity.ok("hello Admin!: "+MDC.get("username"));
    }
}


//515F1B578DF8AED248C6D97FBFB0CDDA
//515F1B578DF8AED248C6D97FBFB0CDDA
//515F1B578DF8AED248C6D97FBFB0CDDA
