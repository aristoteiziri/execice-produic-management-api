package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.CommercialUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercialUnitRepository extends JpaRepository<CommercialUnit, Long> {
    Optional<CommercialUnit> findByName(String name);
    Optional<CommercialUnit> findByAbbreviation(String abbreviation);
}
