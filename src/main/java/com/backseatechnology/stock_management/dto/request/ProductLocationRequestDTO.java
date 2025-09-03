package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * DTO pour la création ou la mise à jour d'un emplacement de produit.
 */
public record ProductLocationRequestDTO(
        @NotNull(message = "Branch ID cannot be null.")
                                         Long brancheId,

                                         @NotNull(message = "Product Location Type ID cannot be null.")
                                         Long productLocationTypeId,

                                         @NotNull(message = "The location code cannot be null.")
                                         UUID code,

                                         @NotBlank(message = "The location name cannot be empty.")
                                         String name,

                                         String zone,
                                         String section,
                                         String floor,
                                         String description) {

}
