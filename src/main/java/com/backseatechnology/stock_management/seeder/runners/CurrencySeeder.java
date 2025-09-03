package com.backseatechnology.stock_management.seeder.runners;

import com.backseatechnology.stock_management.entity.Currency;
import com.backseatechnology.stock_management.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CurrencySeeder {
    private final CurrencyRepository currencyRepository;

    public void seed() {
        if (currencyRepository.count() == 0) {
            log.info("Seeding Currency data...");

            Currency usd = Currency.builder().name("US Dollar").code("USD").build();
            Currency cdf = Currency.builder().name("Congolese Franc").code("CDF").build();
            Currency eur = Currency.builder().name("Euro").code("EUR").build();

            currencyRepository.saveAll(List.of(usd, cdf, eur));
            log.info("✅ Currency data seeded successfully.");
        } else {
            log.warn("Currency data already exists. Skipping seeding.");
        }
    }
}
