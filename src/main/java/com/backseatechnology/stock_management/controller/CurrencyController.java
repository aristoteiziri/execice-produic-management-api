package com.backseatechnology.stock_management.controller;


import com.backseatechnology.stock_management.dto.request.CurrencyRequestDTO;
import com.backseatechnology.stock_management.dto.response.CurrencyResponseDTO;
import com.backseatechnology.stock_management.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<CurrencyResponseDTO> createCurrency(@Valid @RequestBody CurrencyRequestDTO requestDTO) {
        CurrencyResponseDTO createdCurrency = currencyService.createCurrency(requestDTO);
        return new ResponseEntity<>(createdCurrency, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResponseDTO> getCurrencyById(@PathVariable Long id) {
        return ResponseEntity.ok(currencyService.getCurrencyById(id));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponseDTO>> getAllCurrencies() {
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyResponseDTO> updateCurrency(@PathVariable Long id, @Valid @RequestBody CurrencyRequestDTO requestDTO) {
        return ResponseEntity.ok(currencyService.updateCurrency(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }
}
