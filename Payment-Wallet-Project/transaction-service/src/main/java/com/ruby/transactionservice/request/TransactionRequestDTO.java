package com.ruby.transactionservice.request;

import lombok.Data;

@Data
public class TransactionRequestDTO {
    Long fromUserId;
    Long toUserId;
    Double amount;

}
