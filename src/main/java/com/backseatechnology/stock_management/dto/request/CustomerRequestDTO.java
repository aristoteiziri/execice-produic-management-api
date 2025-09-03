package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequestDTO(
        @NotBlank(message = "The customer name cannot be empty.")
        @Size(min = 2, message = "The customer name must have at least 2 characters.")
        String name,

        @NotBlank(message = "The phone number cannot be empty.")
        @Size(min = 9, message = "The phone number seems too short.")
        String phone,

        @Email(message = "The email address must be valid.")
        @Size(max = 100, message = "The email cannot exceed 100 characters.")
        String email

) {}
