package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record SupplierRequestDTO(
        @NotBlank(message = "The supplier name cannot be empty.")
        @Size(max = 100, message = "The name cannot exceed 100 characters.")
        String name,

        @NotBlank(message = "The address cannot be empty.")
        String address,

        @NotBlank(message = "The email cannot be empty.")
        @Email(message = "The email address must be valid.")
        String email,

        @NotBlank(message = "The phone number cannot be empty.")
        String phone
) {
}
