package com.backseatechnology.stock_management.dto.response;

import java.math.BigDecimal;

public record StockRequestItemResponseDTO(
        Long id,
        ProductResponseDTO product,
        CommercialUnitResponseDTO commercialUnit,
        CurrencyResponseDTO currency,
        Integer quantity,
        BigDecimal unitPrice,
        String observation
) {
}
