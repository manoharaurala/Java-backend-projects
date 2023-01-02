package com.example.springsecuritydemo2.controller;

import com.example.springsecuritydemo2.dbmodel.MyUser;
import com.example.springsecuritydemo2.repo.MyUserRepo;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @Autowired
    private MyUserRepo myUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/admin/changePassword")
    ResponseEntity<String> chnagePassword(@RequestParam String newPassword){
        String username= MDC.get("username");
        MyUser myUser=myUserRepo.findByUsername(username);
        myUser.setPassword(passwordEncoder.encode(newPassword));
        myUserRepo.save(myUser);
        return ResponseEntity.ok("Change password");

    }

}
