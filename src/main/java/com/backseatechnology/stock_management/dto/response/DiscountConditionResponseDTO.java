package com.backseatechnology.stock_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
public record DiscountConditionResponseDTO(
        Long id,
        String name,
        BigDecimal percentage,
        BigDecimal fixedAmount,
        BigDecimal minCondition,
        Boolean eligibleCustomer,
        Boolean specificProduct,
        Boolean vatInclused,
        Boolean cumulable,
        String description,

        // DTOs imbriqués pour les relations
        BrancheResponseDTO branch,
        CurrencyResponseDTO currency,
        Set<ProductResponseDTO> products,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date startDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date endDate,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
