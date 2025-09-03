package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.Branche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrancheRepository extends JpaRepository<Branche, Long> {
    /**
     * Finds a branch by its unique business code.
     * @param code The UUID code of the branch.
     * @return An Optional containing the branch if found.
     */
    Optional<Branche> findByCode(UUID code);

    /**
     * Finds a branch by its unique name.
     * @param name The name of the branch.
     * @return An Optional containing the branch if found.
     */
    Optional<Branche> findByName(String name);

    /**
     * Checks if a branch exists by its code.
     * @param code The UUID code.
     * @return true if it exists, false otherwise.
     */
    boolean existsByCode(UUID code);
}
