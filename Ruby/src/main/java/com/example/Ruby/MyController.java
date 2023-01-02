package com.example.Ruby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController {

    @GetMapping
    public String hello(){
        return  "hello Ruby: "+Thread.currentThread().getName();
    }


    @GetMapping("/annaya")
    public String hello2(){
        return  "hello Annaya: "+Thread.currentThread().getName();
    }

    @PostMapping
    public String hellopost(){
        return "hello Ruby: "+Thread.currentThread().getName();
    }

}


