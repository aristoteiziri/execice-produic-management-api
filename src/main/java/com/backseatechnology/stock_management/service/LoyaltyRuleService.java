package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.LoyaltyRuleRequestDTO;
import com.backseatechnology.stock_management.dto.response.LoyaltyRuleResponseDTO;

public interface LoyaltyRuleService {
    LoyaltyRuleResponseDTO createOrUpdateLoyaltyRule(LoyaltyRuleRequestDTO requestDTO);
    LoyaltyRuleResponseDTO getLoyaltyRule();
    void deleteLoyaltyRule();
}
