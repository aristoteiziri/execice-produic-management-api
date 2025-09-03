package com.backseatechnology.stock_management.seeder;

import com.backseatechnology.stock_management.seeder.runners.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {
    // Injection des seeders spécifiques
    private final BrancheTypeSeeder brancheTypeSeeder;
    private final BrancheSeeder brancheSeeder;
    private final CurrencySeeder currencySeeder;
    private final LoyaltyRuleSeeder loyaltyRuleSeeder;
    private final ProductCategorySeeder productCategorySeeder;
    private final VatRateSeeder vatRateSeeder;
    private final CommercialUnitSeeder commercialUnitSeeder;
    private final ProductLocationTypeSeeder productLocationTypeSeeder;

    @Override
    public void run(String... args) throws Exception {
        log.info("🚀 Starting database seeding process...");

        // Exécution dans l'ordre de dépendance
        brancheTypeSeeder.seed();
        brancheSeeder.seed();
        currencySeeder.seed();
        loyaltyRuleSeeder.seed();
        productCategorySeeder.seed();
        vatRateSeeder.seed();
        commercialUnitSeeder.seed();
        productLocationTypeSeeder.seed();

        log.info("🏁 Database seeding process finished.");
    }
}
