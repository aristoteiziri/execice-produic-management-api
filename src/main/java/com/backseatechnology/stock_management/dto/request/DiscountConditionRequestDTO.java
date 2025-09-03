package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
public record DiscountConditionRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
        Long branchId,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        // Pour la relation ManyToMany, on passe une liste d'IDs
        Set<Long> productIds,

        @NotBlank(message = "The name cannot be empty.")
        @Size(max = 255, message = "Name is too long.")
        String name,

        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 3, fraction = 2)
        BigDecimal percentage,

        @Positive(message = "Fixed amount must be positive.")
        BigDecimal fixedAmount,

        @NotNull(message = "Minimum condition cannot be null.")
        @PositiveOrZero(message = "Minimum condition must be positive or zero.")
        BigDecimal minCondition,

        @NotNull(message = "Eligible customer flag cannot be null.")
        Boolean eligibleCustomer,

        @NotNull(message = "Specific product flag cannot be null.")
        Boolean specificProduct,

        @NotNull(message = "VAT included flag cannot be null.")
        Boolean vatInclused,

        @NotNull(message = "Cumulable flag cannot be null.")
        Boolean cumulable,

        @NotNull(message = "Start date cannot be null.")
        @FutureOrPresent(message = "Start date must be in the present or future.")
        Date startDate,

        @Future(message = "End date must be in the future.")
        Date endDate,

        String description
) {}
