package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.LoyaltyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoyaltyRuleRepository extends JpaRepository<LoyaltyRule, Long> {
    /**
     * Finds the first (and likely only) loyalty rule in the system.
     * @return An Optional containing the rule if it exists.
     */
    Optional<LoyaltyRule> findFirstByOrderByIdAsc();
}
