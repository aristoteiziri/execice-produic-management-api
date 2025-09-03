package com.backseatechnology.stock_management.dto.request;

import com.backseatechnology.stock_management.utils.enums.commercial_unit.CommercialUnitTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommercialUnitRequestDTO(
        @NotBlank(message = "The name cannot be empty.")
        @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters.")
        String name,

        @NotBlank(message = "The description cannot be empty.")
        String description,

        @Size(max = 6, message = "The abbreviation cannot exceed 6 characters.")
        String abbreviation,

        @NotNull(message = "The commercial unit type cannot be null.")
        CommercialUnitTypeEnum type
) {}
