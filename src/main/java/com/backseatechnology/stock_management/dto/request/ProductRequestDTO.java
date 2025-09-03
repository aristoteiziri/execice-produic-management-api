package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
public record ProductRequestDTO(
        @NotNull(message = "Product category ID cannot be null.")
        Long productCategoryId,

        @NotNull(message = "Commercial unit ID cannot be null.")
        Long commercialUnitId,

        @NotNull(message = "VAT applicable flag cannot be null.")
        Boolean isVatApplicable,

        String description,

        @Future(message = "Expiration date must be in the future.")
        LocalDate expirationDate
) {
}
