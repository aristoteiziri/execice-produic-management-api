package com.backseatechnology.stock_management.seeder.runners;


import com.backseatechnology.stock_management.entity.ProductCategory;
import com.backseatechnology.stock_management.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductCategorySeeder {

    private final ProductCategoryRepository categoryRepository;
    public void seed() {
        if (categoryRepository.count() == 0) {
            log.info("Seeding ProductCategory data...");

            ProductCategory cat1 = ProductCategory.builder().name("Boissons").description("Boissons gazeuses, jus, eau, etc.").build();
            ProductCategory cat2 = ProductCategory.builder().name("Produits Secs").description("Pâtes, riz, conserves, etc.").build();
            ProductCategory cat3 = ProductCategory.builder().name("Produits Frais").description("Légumes, fruits, viandes, etc.").build();
            ProductCategory cat4 = ProductCategory.builder().name("Entretien").description("Produits de nettoyage et d'hygiène.").build();

            categoryRepository.saveAll(List.of(cat1, cat2, cat3, cat4));
            log.info("✅ ProductCategory data seeded successfully.");
        } else {
            log.warn("ProductCategory data already exists. Skipping seeding.");
        }
    }
}
