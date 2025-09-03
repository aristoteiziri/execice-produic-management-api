package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.Branche;
import com.backseatechnology.stock_management.entity.BrancheType;
import com.backseatechnology.stock_management.repository.BrancheRepository;
import com.backseatechnology.stock_management.repository.BrancheTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BrancheSeeder {
    private final BrancheRepository brancheRepository;
    private final BrancheTypeRepository brancheTypeRepository;

    public void seed() {
        if (brancheRepository.count() == 0) {
            log.info("Seeding Branche data...");

            // Récupérer les types de branche créés précédemment
            BrancheType depotType = brancheTypeRepository.findByName("Dépôt Principal")
                    .orElseThrow(() -> new RuntimeException("Seeding failed: BrancheType 'Dépôt Principal' not found."));
            BrancheType boutiqueType = brancheTypeRepository.findByName("Boutique")
                    .orElseThrow(() -> new RuntimeException("Seeding failed: BrancheType 'Boutique' not found."));

            Branche depotCentral = Branche.builder()
                    .name("Dépôt Central Kinshasa")
                    .address("123, Av. de l'Entrepôt, Gombe")
                    .city("Kinshasa")
                    .phone("0810000001")
                    .email("depot.kin@example.com")
                    .brancheType(depotType)
                    .build();

            Branche boutiqueLimete = Branche.builder()
                    .name("Boutique Limete 7ème Rue")
                    .address("456, 7ème Rue, Limete")
                    .city("Kinshasa")
                    .phone("0810000002")
                    .email("boutique.limete@example.com")
                    .brancheType(boutiqueType)
                    .build();

            brancheRepository.saveAll(List.of(depotCentral, boutiqueLimete));
            log.info("✅ Branche data seeded successfully.");
        } else {
            log.warn("Branche data already exists. Skipping seeding.");
        }
    }
}
