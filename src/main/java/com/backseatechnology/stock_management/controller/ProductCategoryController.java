package com.backseatechnology.stock_management.controller;

import com.backseatechnology.stock_management.dto.request.ProductCategoryRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductCategoryResponseDTO;
import com.backseatechnology.stock_management.service.ProductCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService categoryService;

    @PostMapping
    public ResponseEntity<ProductCategoryResponseDTO> createCategory(@Valid @RequestBody ProductCategoryRequestDTO requestDTO) {
        ProductCategoryResponseDTO createdCategory = categoryService.createCategory(requestDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody ProductCategoryRequestDTO requestDTO) {
        return ResponseEntity.ok(categoryService.updateCategory(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
