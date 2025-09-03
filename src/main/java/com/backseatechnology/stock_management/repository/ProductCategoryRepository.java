package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    /**
     * Finds a product category by its unique name.
     * @param name The name of the category.
     * @return An Optional containing the category if found.
     */
    Optional<ProductCategory> findByName(String name);
}
