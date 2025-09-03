package com.backseatechnology.stock_management.dto.response;

import com.backseatechnology.stock_management.utils.enums.delivery.DeliveryStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;
public record DeliveryResponseDTO(
        UUID code,
        BrancheResponseDTO branche,
        SaleResponseDTO sale,
        CustomerResponseDTO customer,
        MeansTransportResponseDTO meansTransport,
        DeliveryStatusEnum status,
        String deliveryAddress,
        String description,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime scheduledDelivery,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime actualDeliveryDate,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime updatedAt
) {
}
