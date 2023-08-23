package com.example.springdemoproject.service;

import com.example.springdemoproject.dto.CustomerDto;
import com.example.springdemoproject.dto.CustomerDtoConverter;
import com.example.springdemoproject.exception.CustomerNotFoundException;
import com.example.springdemoproject.model.Customer;
import com.example.springdemoproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer could not found by id " + id));
    }


    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
