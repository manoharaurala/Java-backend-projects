package com.example.springsecuritydemo2.dbmodel;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class MyUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String role;
    transient public List<SimpleGrantedAuthority> authorities;

    public MyUser(){

    }

    public MyUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
    }

    @PostLoad
    public void initAuthorities(){
        authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
