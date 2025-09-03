package com.backseatechnology.stock_management.repository;


import com.backseatechnology.stock_management.entity.VatRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VatRateRepository extends JpaRepository<VatRate, Long> {

        /**
         * Trouve le taux de TVA actif pour une date spécifique.
         * Un taux est considéré comme actif si la date donnée est entre sa date de début (incluse)
         * et sa date de fin (incluse), ou si sa date de fin est nulle.
         */
        @Query("SELECT v FROM VatRate v WHERE v.startDate <= :date AND (v.endDate IS NULL OR v.endDate >= :date)")
        Optional<VatRate> findActiveRateForDate(@Param("date") LocalDate date);

        /**
         * Trouve les taux de TVA qui se chevauchent avec une période donnée, en excluant un ID spécifique (utile pour la mise à jour).
         */
        @Query("SELECT v FROM VatRate v WHERE v.id <> :excludedId AND ((v.startDate <= :endDate AND v.endDate IS NULL) OR (v.endDate >= :startDate AND :endDate IS NULL) OR (v.startDate <= :endDate AND v.endDate >= :startDate))")
        List<VatRate> findOverlappingRates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("excludedId") Long excludedId);
    }
