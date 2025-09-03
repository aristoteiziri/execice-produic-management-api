package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
public record StockRequestItemRequestDTO(
        @NotNull(message = "Stock Request ID cannot be null.")
        Long stockRequestId,

        @NotNull(message = "Product ID cannot be null.")
        Long productId,

        @NotNull(message = "Commercial Unit ID cannot be null.")
        Long commercialUnitId,

        // La devise est optionnelle
        Long currencyId,

        @NotNull(message = "Quantity cannot be null.")
        @Positive(message = "Quantity must be a positive number.")
        Integer quantity,

        @NotNull(message = "Unit price cannot be null.")
        @PositiveOrZero(message = "Unit price must be positive or zero.")
        BigDecimal unitPrice,

        @NotBlank(message = "Observation cannot be empty.")
        String observation
) {
}
