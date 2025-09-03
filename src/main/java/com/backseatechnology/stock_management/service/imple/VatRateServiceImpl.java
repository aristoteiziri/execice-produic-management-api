package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.dto.request.VatRateRequestDTO;
import com.backseatechnology.stock_management.dto.response.VatRateResponseDTO;
import com.backseatechnology.stock_management.entity.VatRate;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.VatRateMapper;
import com.backseatechnology.stock_management.repository.VatRateRepository;
import com.backseatechnology.stock_management.service.VatRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VatRateServiceImpl implements VatRateService{

        private final VatRateRepository vatRateRepository;
        private final VatRateMapper vatRateMapper;

        @Override
        @Transactional
        public VatRateResponseDTO createVatRate(VatRateRequestDTO requestDTO) {
            validateDateRange(requestDTO.startDate(), requestDTO.endDate(), -1L); // -1L pour exclure aucun ID
            VatRate vatRate = vatRateMapper.toEntity(requestDTO);
            VatRate savedVatRate = vatRateRepository.save(vatRate);
            return vatRateMapper.toResponseDTO(savedVatRate);
        }

        @Override
        @Transactional
        public VatRateResponseDTO updateVatRate(Long id, VatRateRequestDTO requestDTO) {
            VatRate existingVatRate = vatRateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("VatRate", "id", id));

            validateDateRange(requestDTO.startDate(), requestDTO.endDate(), id);
            vatRateMapper.updateEntityFromDTO(existingVatRate, requestDTO);
            VatRate updatedVatRate = vatRateRepository.save(existingVatRate);
            return vatRateMapper.toResponseDTO(updatedVatRate);
        }

        @Override
        @Transactional(readOnly = true)
        public Optional<VatRateResponseDTO> getCurrentVatRate() {
            return vatRateRepository.findActiveRateForDate(LocalDate.now())
                    .map(vatRateMapper::toResponseDTO);
        }

        // Méthodes CRUD standard
        @Override
        @Transactional(readOnly = true)
        public VatRateResponseDTO getVatRateById(Long id) {
            return vatRateRepository.findById(id)
                    .map(vatRateMapper::toResponseDTO)
                    .orElseThrow(() -> new ResourceNotFoundException("VatRate", "id", id));
        }

        @Override
        @Transactional(readOnly = true)
        public List<VatRateResponseDTO> getAllVatRates() {
            return vatRateRepository.findAll().stream()
                    .map(vatRateMapper::toResponseDTO)
                    .collect(Collectors.toList());
        }

        @Override
        @Transactional
        public void deleteVatRate(Long id) {
            if (!vatRateRepository.existsById(id)) {
                throw new ResourceNotFoundException("VatRate", "id", id);
            }
            vatRateRepository.deleteById(id);
        }

        // Méthode de validation privée
        private void validateDateRange(LocalDate startDate, LocalDate endDate, Long excludedId) {
            if (endDate != null && startDate.isAfter(endDate)) {
                throw new IllegalArgumentException("Start date cannot be after end date.");
            }
            List<VatRate> overlappingRates = vatRateRepository.findOverlappingRates(startDate, endDate, excludedId);
            if (!overlappingRates.isEmpty()) {
                throw new IllegalArgumentException("The provided date range overlaps with an existing VAT rate.");
            }
        }
    }
