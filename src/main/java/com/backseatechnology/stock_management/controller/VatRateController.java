package com.backseatechnology.stock_management.controller;


import com.backseatechnology.stock_management.dto.request.VatRateRequestDTO;
import com.backseatechnology.stock_management.dto.response.VatRateResponseDTO;
import com.backseatechnology.stock_management.service.VatRateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vat-rates")
@RequiredArgsConstructor
public class VatRateController {

    private final VatRateService vatRateService;

    @PostMapping
    public ResponseEntity<VatRateResponseDTO> createVatRate(@Valid @RequestBody VatRateRequestDTO requestDTO) {
        return new ResponseEntity<>(vatRateService.createVatRate(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/current")
    public ResponseEntity<VatRateResponseDTO> getCurrentVatRate() {
        return vatRateService.getCurrentVatRate()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VatRateResponseDTO> getVatRateById(@PathVariable Long id) {
        return ResponseEntity.ok(vatRateService.getVatRateById(id));
    }

    @GetMapping
    public ResponseEntity<List<VatRateResponseDTO>> getAllVatRates() {
        return ResponseEntity.ok(vatRateService.getAllVatRates());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VatRateResponseDTO> updateVatRate(@PathVariable Long id, @Valid @RequestBody VatRateRequestDTO requestDTO) {
        return ResponseEntity.ok(vatRateService.updateVatRate(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVatRate(@PathVariable Long id) {
        vatRateService.deleteVatRate(id);
        return ResponseEntity.noContent().build();
    }
}
