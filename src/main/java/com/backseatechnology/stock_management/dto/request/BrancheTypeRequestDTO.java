package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BrancheTypeRequestDTO(
        @NotBlank(message = "The name cannot be empty.")
        @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters.")
        String name
) {}
