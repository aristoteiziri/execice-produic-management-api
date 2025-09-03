package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record CurrencyRequestDTO(
        @NotBlank(message = "The currency name cannot be empty.")
        @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters.")
        String name,

        @NotBlank(message = "The currency code cannot be empty.")
        @Size(min = 2, max = 5, message = "The code must be between 2 and 5 characters.")
        String code
) {
}
