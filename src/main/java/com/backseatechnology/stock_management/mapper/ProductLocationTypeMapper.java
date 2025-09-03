package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.ProductLocationTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductLocationTypeResponseDTO;
import com.backseatechnology.stock_management.entity.ProductLocationType;
import org.springframework.stereotype.Component;

@Component
public class ProductLocationTypeMapper {
    public ProductLocationTypeResponseDTO toResponseDTO(ProductLocationType type) {
        if (type == null) {
            return null;
        }
        return new ProductLocationTypeResponseDTO(
                type.getId(),
                type.getName(),
                type.getObservation(),
                type.getCreatedAt(),
                type.getUpdatedAt()
        );
    }

    public ProductLocationType toEntity(ProductLocationTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return ProductLocationType.builder()
                .name(dto.name())
                .observation(dto.observation())
                .build();
    }

    public void updateEntityFromDTO(ProductLocationType type, ProductLocationTypeRequestDTO dto) {
        type.setName(dto.name());
        type.setObservation(dto.observation());
    }
}
