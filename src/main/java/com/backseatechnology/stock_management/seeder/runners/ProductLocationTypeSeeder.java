package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.ProductLocationType;
import com.backseatechnology.stock_management.repository.ProductLocationTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductLocationTypeSeeder {
    private final ProductLocationTypeRepository locationTypeRepository;

    public void seed() {
        if (locationTypeRepository.count() == 0) {
            log.info("Seeding ProductLocationType data...");

            ProductLocationType type1 = ProductLocationType.builder().name("Rayon").observation("Emplacement de vente principal en magasin.").build();
            ProductLocationType type2 = ProductLocationType.builder().name("Réserve").observation("Stock arrière non accessible aux clients.").build();
            ProductLocationType type3 = ProductLocationType.builder().name("Entrepôt").observation("Lieu de stockage de masse.").build();
            ProductLocationType type4 = ProductLocationType.builder().name("Zone de Réception").observation("Zone de déchargement et de contrôle des marchandises.").build();
            ProductLocationType type5 = ProductLocationType.builder().name("Zone d'Expédition").observation("Zone de préparation des commandes et de chargement.").build();
            ProductLocationType type6 = ProductLocationType.builder().name("Chambre Froide").observation("Emplacement à température contrôlée pour produits périssables.").build();

            locationTypeRepository.saveAll(List.of(type1, type2, type3, type4, type5, type6));
            log.info("✅ ProductLocationType data seeded successfully.");
        } else {
            log.warn("ProductLocationType data already exists. Skipping seeding.");
        }
    }
}
