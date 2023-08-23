package com.example.springdemoproject.dto;

import java.util.Set;

public record CustomerDto(
        String id,
        String name,
        String surname,
        Set<CustomerAccountDto> accounts
) {
}
