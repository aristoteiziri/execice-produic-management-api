package com.backseatechnology.stock_management.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DeliveryRequestDTO(

        @NotNull(message = "Sale ID cannot be null.")
        Long saleId,

        @NotNull(message = "Customer ID cannot be null.")
        Long customerId,

        @NotNull(message = "Means of Transport ID cannot be null.")
        Long meansTransportId,

        @NotBlank(message = "Delivery address cannot be empty.")
        String deliveryAddress,

        @NotNull(message = "Scheduled delivery date cannot be null.")
        @Future(message = "Scheduled delivery date must be in the future.")
        LocalDateTime scheduledDelivery,

        @Size(max = 500, message = "Description cannot exceed 500 characters.")
        String description
) {
}
