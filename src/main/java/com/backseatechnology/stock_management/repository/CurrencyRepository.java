package com.backseatechnology.stock_management.repository;

import com.backseatechnology.stock_management.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Long> {

    /**
     * Finds a currency by its unique name.
     * @param name The name of the currency (e.g., "US Dollar").
     * @return An Optional containing the currency if found.
     */
    Optional<Currency> findByName(String name);

    /**
     * Finds a currency by its unique ISO code.
     * @param code The code of the currency (e.g., "USD").
     * @return An Optional containing the currency if found.
     */
    Optional<Currency> findByCode(String code);
}
