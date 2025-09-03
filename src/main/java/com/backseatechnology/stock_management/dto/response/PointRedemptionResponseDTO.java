package com.backseatechnology.stock_management.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PointRedemptionResponseDTO(
        Long id,
        BrancheResponseDTO branche,
        CustomerResponseDTO customer,
        CurrencyResponseDTO currency,
        Integer pointUsed,
        BigDecimal amountDiscounted,
        String description,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime usedAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
