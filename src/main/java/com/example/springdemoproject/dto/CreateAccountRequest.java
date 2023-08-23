package com.example.springdemoproject.dto;

import java.math.BigDecimal;

public record CreateAccountRequest(
        String customerId,
        BigDecimal initialCredit
) {
}
