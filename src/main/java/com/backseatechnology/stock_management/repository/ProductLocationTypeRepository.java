package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.ProductLocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductLocationTypeRepository extends JpaRepository<ProductLocationType, Long> {

    /**
     * Finds a product location type by its unique name.
     * @param name The name of the location type.
     * @return An Optional containing the location type if found.
     */
    Optional<ProductLocationType> findByName(String name);
}
