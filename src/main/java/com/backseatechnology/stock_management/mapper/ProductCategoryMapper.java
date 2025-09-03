package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.ProductCategoryRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductCategoryResponseDTO;
import com.backseatechnology.stock_management.entity.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {
    public ProductCategoryResponseDTO toResponseDTO(ProductCategory category) {
        if (category == null) {
            return null;
        }
        return new ProductCategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }

    public ProductCategory toEntity(ProductCategoryRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return ProductCategory.builder()
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    public void updateEntityFromDTO(ProductCategory category, ProductCategoryRequestDTO dto) {
        category.setName(dto.name());
        category.setDescription(dto.description());
    }
}
