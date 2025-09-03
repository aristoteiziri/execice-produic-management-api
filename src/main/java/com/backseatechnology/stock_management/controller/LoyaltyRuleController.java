package com.backseatechnology.stock_management.controller;

import com.backseatechnology.stock_management.dto.request.LoyaltyRuleRequestDTO;
import com.backseatechnology.stock_management.dto.response.LoyaltyRuleResponseDTO;
import com.backseatechnology.stock_management.service.LoyaltyRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loyalty-rule")
@RequiredArgsConstructor
public class LoyaltyRuleController {

    private final LoyaltyRuleService loyaltyRuleService;

    @GetMapping
    public ResponseEntity<LoyaltyRuleResponseDTO> getLoyaltyRule() {
        return ResponseEntity.ok(loyaltyRuleService.getLoyaltyRule());
    }

    @PostMapping
    public ResponseEntity<LoyaltyRuleResponseDTO> createOrUpdateLoyaltyRule(@Valid @RequestBody LoyaltyRuleRequestDTO requestDTO) {
        LoyaltyRuleResponseDTO response = loyaltyRuleService.createOrUpdateLoyaltyRule(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLoyaltyRule() {
        loyaltyRuleService.deleteLoyaltyRule();
        return ResponseEntity.noContent().build();
    }
}
