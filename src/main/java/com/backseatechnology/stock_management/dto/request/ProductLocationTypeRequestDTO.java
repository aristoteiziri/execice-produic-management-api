package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO pour la création ou la mise à jour d'un type d'emplacement de produit.
 */
public record ProductLocationTypeRequestDTO(
        @NotBlank(message = "The name cannot be empty.")
        @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters.")
        String name,

        @Size(max = 500, message = "The observation cannot exceed 500 characters.")
        String observation
) {
}
