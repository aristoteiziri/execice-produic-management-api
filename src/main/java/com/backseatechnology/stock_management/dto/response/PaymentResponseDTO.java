package com.backseatechnology.stock_management.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public record PaymentResponseDTO(
        Long id,
        BrancheResponseDTO branche,
        SaleResponseDTO sale,
        MeansPaymentResponseDTO meansPayment,
        CurrencyResponseDTO currency,
        BigDecimal finalAmount,
        String sourceRate,
        BigDecimal conversionRate,
        BigDecimal totalCumulativeTaxAmount,
        BigDecimal vatRate,
        BigDecimal discountAmount,
        BigDecimal vatAmount,
        BigDecimal totalAmountExcludingTax,
        String description,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
