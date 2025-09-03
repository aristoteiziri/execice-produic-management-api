package com.backseatechnology.stock_management.dto.request;

import com.backseatechnology.stock_management.utils.enums.means_transport.MeansTransportEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record MeansTransportRequestDTO(
        @NotBlank(message = "The model cannot be empty.")
        @Size(max = 100, message = "Model name is too long.")
        String model,

        @Size(max = 100, message = "Brand name is too long.")
        String brand,

        @Size(max = 50, message = "Registration number is too long.")
        String registration,

        @NotBlank(message = "The chassis number cannot be empty.")
        @Size(max = 100, message = "Chassis number is too long.")
        String chassisNumber,

        @NotNull(message = "Type of transportation ID cannot be null.")
        Long typeTransportationId,

        MeansTransportEnum status,

        @Size(max = 500, message = "Description is too long.")
        String description
) {}
