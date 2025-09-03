package com.backseatechnology.stock_management.dto.response;

import com.backseatechnology.stock_management.utils.enums.stock_request.StockRequestStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record StockRequestResponseDTO(
        Long id,
        BrancheResponseDTO branche,
        Long sourceId,
        String sourceType,
        CurrencyResponseDTO currency,
        BigDecimal totalPrice,
        Boolean isTransferRequest,
        StockRequestStatusEnum status,
        String description,
        Set<StockRequestItemResponseDTO> items,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
