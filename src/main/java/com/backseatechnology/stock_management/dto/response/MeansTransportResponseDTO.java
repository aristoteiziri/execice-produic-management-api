package com.backseatechnology.stock_management.dto.response;

import com.backseatechnology.stock_management.utils.enums.means_transport.MeansTransportEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
public record MeansTransportResponseDTO(
        Long id,
        String model,
        String brand,
        String registration,
        String chassisNumber,
        TypeTransportationResponseDTO typeTransportation,
        MeansTransportEnum status,
        String description,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
