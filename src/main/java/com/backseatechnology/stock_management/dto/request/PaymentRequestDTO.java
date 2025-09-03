package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
public record PaymentRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
        Long brancheId,

        @NotNull(message = "Sale ID cannot be null.")
        Long saleId,

        @NotNull(message = "Means of Payment ID cannot be null.")
        Long meansPaymentId,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        @NotNull(message = "Final amount cannot be null.")
        @Positive(message = "Final amount must be positive.")
        BigDecimal finalAmount,

        String sourceRate,

        BigDecimal conversionRate,

        @NotNull(message = "VAT rate cannot be null.")
        @PositiveOrZero(message = "VAT rate must be positive or zero.")
        BigDecimal vatRate,

        String description
) {}
