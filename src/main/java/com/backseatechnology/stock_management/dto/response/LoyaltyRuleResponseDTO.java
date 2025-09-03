package com.backseatechnology.stock_management.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
public record LoyaltyRuleResponseDTO(
        BigDecimal minAmount,
        Integer pointPerAmount,
        BigDecimal equivalentValue,
        Integer expiresInDays,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {}
