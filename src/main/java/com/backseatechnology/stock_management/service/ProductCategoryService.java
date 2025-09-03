package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.ProductCategoryRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductCategoryResponseDTO;

import java.util.List;
public interface ProductCategoryService {
    ProductCategoryResponseDTO createCategory(ProductCategoryRequestDTO requestDTO);
    ProductCategoryResponseDTO getCategoryById(Long id);
    List<ProductCategoryResponseDTO> getAllCategories();
    ProductCategoryResponseDTO updateCategory(Long id, ProductCategoryRequestDTO requestDTO);
    void deleteCategory(Long id);
}
