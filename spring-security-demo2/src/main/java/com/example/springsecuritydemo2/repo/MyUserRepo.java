package com.example.springsecuritydemo2.repo;

import com.example.springsecuritydemo2.dbmodel.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Long> {
    MyUser findByUsername(String username);
}
