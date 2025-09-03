package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
public record PriceRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
        Long brancheId,

        @NotNull(message = "Product ID cannot be null.")
        Long productId,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        @NotNull(message = "Unit price cannot be null.")
        @Positive(message = "Unit price must be positive.")
        BigDecimal unitPrice
) {
}
