package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.BrancheTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheTypeResponseDTO;
import com.backseatechnology.stock_management.entity.BrancheType;
import org.springframework.stereotype.Component;

@Component
public class BrancheTypeMapper {
    public BrancheTypeResponseDTO toResponseDTO(BrancheType brancheType) {
        if (brancheType == null) {
            return null;
        }
        return new BrancheTypeResponseDTO(
                brancheType.getId(),
                brancheType.getName(),
                brancheType.getCreatedAt(),
                brancheType.getUpdatedAt()
        );
    }

    public BrancheType toEntity(BrancheTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return BrancheType.builder()
                .name(dto.name())
                .build();
    }
}
