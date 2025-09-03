package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.CurrencyRequestDTO;
import com.backseatechnology.stock_management.dto.response.CurrencyResponseDTO;

import java.util.List;
public interface CurrencyService {
    CurrencyResponseDTO createCurrency(CurrencyRequestDTO requestDTO);
    CurrencyResponseDTO getCurrencyById(Long id);
    List<CurrencyResponseDTO> getAllCurrencies();
    CurrencyResponseDTO updateCurrency(Long id, CurrencyRequestDTO requestDTO);
    void deleteCurrency(Long id);
}
