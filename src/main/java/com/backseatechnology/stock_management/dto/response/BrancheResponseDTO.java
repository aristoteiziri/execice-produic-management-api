package com.backseatechnology.stock_management.dto.response;

import com.backseatechnology.stock_management.utils.enums.branche.BrancheStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record BrancheResponseDTO(
        UUID code,
        String name,
        String phone,
        String description,
        String email,
        String commercialRegister,
        String fiscalIdentifier,
        String address,
        String city,
        String state,
        BrancheStatusEnum status,
        BrancheTypeResponseDTO brancheType, // Using the nested record DTO

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
