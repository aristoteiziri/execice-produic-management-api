package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.LoyaltyRule;
import com.backseatechnology.stock_management.repository.LoyaltyRuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoyaltyRuleSeeder {
    private final LoyaltyRuleRepository loyaltyRuleRepository;

    public void seed() {
        if (loyaltyRuleRepository.count() == 0) {
            log.info("Seeding LoyaltyRule data...");

            LoyaltyRule defaultRule = LoyaltyRule.builder()
                    .minAmount(BigDecimal.valueOf(1000)) // Ex: 1 point par tranche de 1000 CDF
                    .pointPerAmount(1)
                    .equivalentValue(BigDecimal.valueOf(50)) // Ex: 1 point vaut 50 CDF
                    .expiresInDays(365) // Les points expirent après 1 an
                    .build();

            loyaltyRuleRepository.save(defaultRule);
            log.info("✅ Default LoyaltyRule data seeded successfully.");
        } else {
            log.warn("LoyaltyRule data already exists. Skipping seeding.");
        }
    }
}
