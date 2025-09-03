package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.BrancheType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrancheTypeRepository extends JpaRepository<BrancheType, Long> {
    /**
     * Finds a branch type by its unique name.
     * @param name The name of the branch type.
     * @return An Optional containing the branch type if found.
     */
    Optional<BrancheType> findByName(String name);
}
