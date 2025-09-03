package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.VatRate;
import com.backseatechnology.stock_management.repository.VatRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class VatRateSeeder {
    private final VatRateRepository vatRateRepository;

    public void seed() {
        if (vatRateRepository.count() == 0) {
            log.info("Seeding VatRate data...");

            // Taux standard de TVA en RDC (16%)
            VatRate currentVat = VatRate.builder()
                    .rate(new BigDecimal("16.00"))
                    .description("Taux standard de TVA en RDC")
                    .startDate(LocalDate.of(2012, 1, 1)) // Date d'instauration de la TVA
                    .endDate(null) // Toujours en vigueur
                    .build();

            vatRateRepository.save(currentVat);
            log.info("✅ Default VatRate (TVA) data seeded successfully.");
        } else {
            log.warn("VatRate data already exists. Skipping seeding.");
        }
    }
}
