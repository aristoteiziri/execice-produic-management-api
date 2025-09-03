package com.backseatechnology.stock_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * Représente les données d'un type d'emplacement de produit renvoyées au client.
 */
public record ProductLocationTypeResponseDTO(
        Long id,
        String name,
        String observation,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
