package com.backseatechnology.stock_management.dto.request;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigInteger;
public record CustomerPointRedemptionRequestDTO(
        @NotNull(message = "Customer ID cannot be null.")
        Long customerId,

        // NOTE : 'pointRedemptionId' is the assumed other part of your composite key.
        // Adjust this name if the column is different in your CustomerPointRedemptionId class.
        @NotNull(message = "Point Redemption ID cannot be null.")
        Long pointRedemptionId,

        @NotNull(message = "Points used cannot be null.")
        @Positive(message = "Points used must be a positive number.")
        BigInteger pointUsed,

        @NotNull(message = "Discounted amount cannot be null.")
        @Positive(message = "Discounted amount must be a positive number.")
        BigDecimal amountDiscounted,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        @Size(max = 500, message = "Description cannot exceed 500 characters.")
        String description
) {
}
