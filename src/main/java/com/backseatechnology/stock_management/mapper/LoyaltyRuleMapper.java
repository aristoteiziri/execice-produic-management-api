package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.LoyaltyRuleRequestDTO;
import com.backseatechnology.stock_management.dto.response.LoyaltyRuleResponseDTO;
import com.backseatechnology.stock_management.entity.LoyaltyRule;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyRuleMapper {
    public LoyaltyRuleResponseDTO toResponseDTO(LoyaltyRule rule) {
        if (rule == null) {
            return null;
        }
        return new LoyaltyRuleResponseDTO(
                rule.getMinAmount(),
                rule.getPointPerAmount(),
                rule.getEquivalentValue(),
                rule.getExpiresInDays(),
                rule.getCreatedAt(),
                rule.getUpdatedAt()
        );
    }

    public LoyaltyRule toEntity(LoyaltyRuleRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return LoyaltyRule.builder()
                .minAmount(dto.minAmount())
                .pointPerAmount(dto.pointPerAmount())
                .equivalentValue(dto.equivalentValue())
                .expiresInDays(dto.expiresInDays())
                .build();
    }

    public void updateEntityFromDTO(LoyaltyRule rule, LoyaltyRuleRequestDTO dto) {
        rule.setMinAmount(dto.minAmount());
        rule.setPointPerAmount(dto.pointPerAmount());
        rule.setEquivalentValue(dto.equivalentValue());
        rule.setExpiresInDays(dto.expiresInDays());
    }
}
