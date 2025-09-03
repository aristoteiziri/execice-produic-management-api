package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.BrancheType;
import com.backseatechnology.stock_management.repository.BrancheTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BrancheTypeSeeder {
    private final BrancheTypeRepository brancheTypeRepository;
    public void seed() {
        if (brancheTypeRepository.count() == 0) {
            log.info("Seeding BrancheType data...");
            BrancheType depot = BrancheType.builder()
                    .name("Dépôt Principal")
                    .build();
            BrancheType boutique = BrancheType.builder()
                    .name("Point de vente")
                    .build();

            brancheTypeRepository.saveAll(List.of(depot, boutique));
            log.info("✅ BrancheType data seeded successfully.");
        } else {
            log.warn("BrancheType data already exists. Skipping seeding.");
        }
    }
}
