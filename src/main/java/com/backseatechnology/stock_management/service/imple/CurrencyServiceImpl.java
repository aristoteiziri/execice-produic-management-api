package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.dto.request.CurrencyRequestDTO;
import com.backseatechnology.stock_management.dto.response.CurrencyResponseDTO;
import com.backseatechnology.stock_management.entity.Currency;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.CurrencyMapper;
import com.backseatechnology.stock_management.repository.CurrencyRepository;
import com.backseatechnology.stock_management.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl  implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    @Transactional
    public CurrencyResponseDTO createCurrency(CurrencyRequestDTO requestDTO) {
        // Vérifier l'unicité du nom et du code
        currencyRepository.findByName(requestDTO.name()).ifPresent(c -> {
            throw new IllegalArgumentException("A currency with the name '" + requestDTO.name() + "' already exists.");
        });
        currencyRepository.findByCode(requestDTO.code()).ifPresent(c -> {
            throw new IllegalArgumentException("A currency with the code '" + requestDTO.code() + "' already exists.");
        });

        Currency currency = currencyMapper.toEntity(requestDTO);
        Currency savedCurrency = currencyRepository.save(currency);
        return currencyMapper.toResponseDTO(savedCurrency);
    }

    @Override
    @Transactional(readOnly = true)
    public CurrencyResponseDTO getCurrencyById(Long id) {
        Currency currency = currencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency", "id", id));
        return currencyMapper.toResponseDTO(currency);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyResponseDTO> getAllCurrencies() {
        return currencyRepository.findAll().stream()
                .map(currencyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CurrencyResponseDTO updateCurrency(Long id, CurrencyRequestDTO requestDTO) {
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency", "id", id));

        // Vérifier l'unicité du nouveau nom et code (en excluant l'entité actuelle)
        currencyRepository.findByName(requestDTO.name()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new IllegalArgumentException("A currency with the name '" + requestDTO.name() + "' already exists.");
            }
        });
        currencyRepository.findByCode(requestDTO.code()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new IllegalArgumentException("A currency with the code '" + requestDTO.code() + "' already exists.");
            }
        });

        existingCurrency.setName(requestDTO.name());
        existingCurrency.setCode(requestDTO.code());
        Currency updatedCurrency = currencyRepository.save(existingCurrency);
        return currencyMapper.toResponseDTO(updatedCurrency);
    }

    @Override
    @Transactional
    public void deleteCurrency(Long id) {
        Currency currency = currencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency", "id", id));

        // Règle métier : Ne pas supprimer une devise si elle est utilisée
        if (currency.getCustomerPointRedemptions() != null && !currency.getCustomerPointRedemptions().isEmpty()) {
            throw new IllegalStateException("Cannot delete currency '" + currency.getName() + "' because it is currently in use.");
        }

        currencyRepository.delete(currency);
    }
}
