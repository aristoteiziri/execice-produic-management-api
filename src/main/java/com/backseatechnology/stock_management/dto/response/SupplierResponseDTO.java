package com.backseatechnology.stock_management.dto.response;

public record SupplierResponseDTO(
        Long id,
        String name,
        String address,
        String email,
        String phone
) {
}
