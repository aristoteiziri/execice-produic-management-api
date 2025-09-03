package com.backseatechnology.stock_management.dto.request;

import com.backseatechnology.stock_management.utils.enums.branche.BrancheStatusEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BrancheRequestDTO(
        @NotBlank(message = "The branch name cannot be empty.")
        @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters.")
        String name,

        @Size(max = 20, message = "The phone number cannot exceed 20 characters.")
        String phone,

        @Size(max = 255, message = "The description cannot exceed 255 characters.")
        String description,

        @Email(message = "The email address must be valid.")
        @Size(max = 100, message = "The email cannot exceed 100 characters.")
        String email,

        @Size(max = 50, message = "The commercial register cannot exceed 50 characters.")
        String commercialRegister,

        @Size(max = 50, message = "The fiscal identifier cannot exceed 50 characters.")
        String fiscalIdentifier,

        String address,
        String city,
        String state,

        @NotNull(message = "The branch type is mandatory.")
        Long brancheTypeId,

        // This field can be null in the JSON if not provided
        BrancheStatusEnum status
) {
}
