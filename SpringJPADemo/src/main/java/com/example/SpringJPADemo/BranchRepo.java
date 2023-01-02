package com.example.SpringJPADemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,Integer> {
}
