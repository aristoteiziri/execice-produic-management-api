package com.backseatechnology.stock_management.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
public record StockRequestRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
        Long brancheId,

        @NotNull(message = "Source ID cannot be null.")
        Long sourceId,

        @NotBlank(message = "Source type cannot be empty.")
        String sourceType,

        @NotNull(message = "Currency ID cannot be null.")
        Long currencyId,

        Boolean isTransferRequest,
        String description,

        @NotEmpty(message = "Stock request must have at least one item.")
        @Valid // Permet de valider les objets dans la collection
        Set<StockRequestItemRequestDTO> items
) {
}
