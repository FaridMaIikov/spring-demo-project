package com.example.springdemoproject.repository;

import com.example.springdemoproject.model.Account;
import com.example.springdemoproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.function.Consumer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
