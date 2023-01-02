package com.ruby.transactionservice.repos;

import com.ruby.transactionservice.entity.Transaction;
import org.omg.IOP.TransactionService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    Transaction findByTxnId(String txnId);

}
