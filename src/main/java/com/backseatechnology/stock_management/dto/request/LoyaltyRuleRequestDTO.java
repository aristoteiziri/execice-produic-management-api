package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
public record LoyaltyRuleRequestDTO(

        @NotNull(message = "Minimum amount cannot be null.")
        @PositiveOrZero(message = "Minimum amount must be zero or positive.")
        BigDecimal minAmount,

        @NotNull(message = "Points per amount cannot be null.")
        @Positive(message = "Points per amount must be a positive number.")
        Integer pointPerAmount,

        @NotNull(message = "Equivalent value cannot be null.")
        @Positive(message = "Equivalent value must be a positive number.")
        BigDecimal equivalentValue,

        @Positive(message = "Expires in days must be a positive number.")
        Integer expiresInDays
) {}
