package com.example.springsecuritydemo2.service;

import com.example.springsecuritydemo2.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DBUserStore implements UserDetailsService {

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserDetails userDetails=myUserRepo.findByUsername(username);
       if(userDetails==null){
           throw new UsernameNotFoundException("User not found"+username);
       }
       return userDetails;
    }
}
