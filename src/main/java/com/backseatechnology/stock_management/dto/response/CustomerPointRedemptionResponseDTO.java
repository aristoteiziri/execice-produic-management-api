package com.backseatechnology.stock_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
public record CustomerPointRedemptionResponseDTO(
        CustomerResponseDTO customer,
        CurrencyResponseDTO currency,
        BigInteger pointUsed,
        BigDecimal amountDiscounted,
        String description,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
