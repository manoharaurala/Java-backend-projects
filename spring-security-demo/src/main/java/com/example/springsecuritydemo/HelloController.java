package com.example.springsecuritydemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        return ResponseEntity.ok("hello");
    }
}


//515F1B578DF8AED248C6D97FBFB0CDDA
//515F1B578DF8AED248C6D97FBFB0CDDA
//515F1B578DF8AED248C6D97FBFB0CDDA
