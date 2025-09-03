package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.CommercialUnitRequestDTO;
import com.backseatechnology.stock_management.dto.response.CommercialUnitResponseDTO;
import com.backseatechnology.stock_management.entity.CommercialUnit;
import org.springframework.stereotype.Component;

@Component
public class CommercialUnitMapper {
    public CommercialUnitResponseDTO toResponseDTO(CommercialUnit unit) {
        if (unit == null) return null;
        return new CommercialUnitResponseDTO(
                unit.getId(),
                unit.getName(),
                unit.getDescription(),
                unit.getAbbreviation(),
                unit.getType()
        );
    }

    public CommercialUnit toEntity(CommercialUnitRequestDTO dto) {
        if (dto == null) return null;
        return CommercialUnit.builder()
                .name(dto.name())
                .description(dto.description())
                .abbreviation(dto.abbreviation())
                .type(dto.type())
                .build();
    }

    public void updateEntityFromDTO(CommercialUnit unit, CommercialUnitRequestDTO dto) {
        unit.setName(dto.name());
        unit.setDescription(dto.description());
        unit.setAbbreviation(dto.abbreviation());
        unit.setType(dto.type());
    }
}
