package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.dto.request.LoyaltyRuleRequestDTO;
import com.backseatechnology.stock_management.dto.response.LoyaltyRuleResponseDTO;
import com.backseatechnology.stock_management.entity.LoyaltyRule;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.LoyaltyRuleMapper;
import com.backseatechnology.stock_management.repository.LoyaltyRuleRepository;
import com.backseatechnology.stock_management.service.LoyaltyRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoyaltyRuleServiceImpl implements LoyaltyRuleService {
    private final LoyaltyRuleRepository loyaltyRuleRepository;
    private final LoyaltyRuleMapper loyaltyRuleMapper;

    @Override
    @Transactional
    public LoyaltyRuleResponseDTO createOrUpdateLoyaltyRule(LoyaltyRuleRequestDTO requestDTO) {
        // Chercher s'il existe déjà une règle
        Optional<LoyaltyRule> existingRuleOpt = loyaltyRuleRepository.findFirstByOrderByIdAsc();

        LoyaltyRule ruleToSave;
        if (existingRuleOpt.isPresent()) {
            // Mettre à jour la règle existante
            ruleToSave = existingRuleOpt.get();
            loyaltyRuleMapper.updateEntityFromDTO(ruleToSave, requestDTO);
        } else {
            // Créer une nouvelle règle
            ruleToSave = loyaltyRuleMapper.toEntity(requestDTO);
        }

        LoyaltyRule savedRule = loyaltyRuleRepository.save(ruleToSave);
        return loyaltyRuleMapper.toResponseDTO(savedRule);
    }

    @Override
    @Transactional(readOnly = true)
    public LoyaltyRuleResponseDTO getLoyaltyRule() {
        LoyaltyRule rule = loyaltyRuleRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new ResourceNotFoundException("LoyaltyRule", "any", "not configured"));
        return loyaltyRuleMapper.toResponseDTO(rule);
    }

    @Override
    @Transactional
    public void deleteLoyaltyRule() {
        LoyaltyRule rule = loyaltyRuleRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new ResourceNotFoundException("LoyaltyRule", "any", "not configured"));
        loyaltyRuleRepository.delete(rule);
    }
}
