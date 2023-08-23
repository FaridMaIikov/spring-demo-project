package com.example.springdemoproject.dto;

import com.example.springdemoproject.model.Transaction;
import com.example.springdemoproject.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


public record TransactionDto(
        String id,
        TransactionType transactionType ,
        BigDecimal amount,
        LocalDateTime transactionDate

) {
}
