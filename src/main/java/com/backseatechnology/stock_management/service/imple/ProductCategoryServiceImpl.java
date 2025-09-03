package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.dto.request.ProductCategoryRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductCategoryResponseDTO;
import com.backseatechnology.stock_management.entity.ProductCategory;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.ProductCategoryMapper;
import com.backseatechnology.stock_management.repository.ProductCategoryRepository;
import com.backseatechnology.stock_management.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService{
    private final ProductCategoryRepository categoryRepository;
    private final ProductCategoryMapper categoryMapper;

    @Override
    @Transactional
    public ProductCategoryResponseDTO createCategory(ProductCategoryRequestDTO requestDTO) {
        categoryRepository.findByName(requestDTO.name()).ifPresent(c -> {
            throw new IllegalArgumentException("A category with the name '" + requestDTO.name() + "' already exists.");
        });

        ProductCategory category = categoryMapper.toEntity(requestDTO);
        ProductCategory savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDTO(savedCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductCategoryResponseDTO getCategoryById(Long id) {
        ProductCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "id", id));
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductCategoryResponseDTO updateCategory(Long id, ProductCategoryRequestDTO requestDTO) {
        ProductCategory existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "id", id));

        categoryRepository.findByName(requestDTO.name()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new IllegalArgumentException("A category with the name '" + requestDTO.name() + "' already exists.");
            }
        });

        categoryMapper.updateEntityFromDTO(existingCategory, requestDTO);
        ProductCategory updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toResponseDTO(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        ProductCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory", "id", id));

        // Règle métier : Ne pas supprimer une catégorie si elle contient des produits
        if (category.getProducts() != null && !category.getProducts().isEmpty()) {
            throw new IllegalStateException("Cannot delete category '" + category.getName() + "' because it contains products.");
        }

        categoryRepository.delete(category);
    }
}
