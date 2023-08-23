package com.example.springdemoproject.repository;

import com.example.springdemoproject.model.Account;
import com.example.springdemoproject.model.Customer;
import com.example.springdemoproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Consumer;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
