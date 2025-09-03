package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public record PointRedemptionRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
        Long brancheId,

        @NotNull(message = "Customer ID cannot be null.")
        Long customerId,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        @NotNull(message = "Points used cannot be null.")
        @Positive(message = "Points used must be a positive number.")
        Integer pointUsed,

        @NotNull(message = "Discounted amount cannot be null.")
        @Positive(message = "Discounted amount must be a positive number.")
        BigDecimal amountDiscounted,

        // Ce champ est optionnel, car il a une valeur par défaut dans l'entité
        LocalDateTime usedAt,

        String description
) {}
