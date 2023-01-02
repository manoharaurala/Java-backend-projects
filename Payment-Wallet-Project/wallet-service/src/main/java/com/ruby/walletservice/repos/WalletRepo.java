package com.ruby.walletservice.repos;

import com.ruby.walletservice.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet,Long> {

    Wallet findByuserId(Long user_id);
}
