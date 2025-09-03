package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.VatRateRequestDTO;
import com.backseatechnology.stock_management.dto.response.VatRateResponseDTO;

import java.util.List;
import java.util.Optional;
public interface VatRateService {
    VatRateResponseDTO createVatRate(VatRateRequestDTO requestDTO);
    VatRateResponseDTO getVatRateById(Long id);
    List<VatRateResponseDTO> getAllVatRates();
    VatRateResponseDTO updateVatRate(Long id, VatRateRequestDTO requestDTO);
    void deleteVatRate(Long id);
    Optional<VatRateResponseDTO> getCurrentVatRate();
}
