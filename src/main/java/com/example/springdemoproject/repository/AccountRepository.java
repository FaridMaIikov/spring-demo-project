package com.example.springdemoproject.repository;

import com.example.springdemoproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Consumer;

public interface AccountRepository extends JpaRepository<Account,String> {
}
