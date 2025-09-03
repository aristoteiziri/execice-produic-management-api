package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO pour la création ou la mise à jour d'un taux de TVA.
 */
public record VatRateRequestDTO(
        @NotNull(message = "The rate cannot be null.")
        @PositiveOrZero(message = "The rate must be positive or zero.")
        @Digits(integer = 3, fraction = 2, message = "The rate format is invalid (e.g., 15.50).")
        BigDecimal rate,

        @NotNull(message = "The start date cannot be null.")
        LocalDate startDate,

        // La date de fin est optionnelle
        LocalDate endDate,

        String description
) {
}
