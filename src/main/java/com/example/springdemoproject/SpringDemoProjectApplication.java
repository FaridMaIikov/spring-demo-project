package com.example.springdemoproject;

import com.example.springdemoproject.model.Customer;
import com.example.springdemoproject.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class SpringDemoProjectApplication implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public SpringDemoProjectApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.save(Customer.builder()
                .name("Ferid")
                .surname("Melikov")
                .build());
        System.out.println(customer);
    }
}
