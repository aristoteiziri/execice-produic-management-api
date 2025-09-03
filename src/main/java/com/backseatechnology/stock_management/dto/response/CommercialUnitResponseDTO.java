package com.backseatechnology.stock_management.dto.response;

import com.backseatechnology.stock_management.utils.enums.commercial_unit.CommercialUnitTypeEnum;

public record CommercialUnitResponseDTO(
        Long id,
        String name,
        String description,
        String abbreviation,
        CommercialUnitTypeEnum type
) {}
