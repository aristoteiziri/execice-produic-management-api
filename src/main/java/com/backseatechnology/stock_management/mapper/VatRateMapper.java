package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.VatRateRequestDTO;
import com.backseatechnology.stock_management.dto.response.VatRateResponseDTO;
import com.backseatechnology.stock_management.entity.VatRate;
import org.springframework.stereotype.Component;

@Component
public class VatRateMapper {

    public VatRateResponseDTO toResponseDTO(VatRate vatRate) {
        if (vatRate == null) {
            return null;
        }
        return new VatRateResponseDTO(
                vatRate.getId(),
                vatRate.getRate(),
                vatRate.getDescription(),
                vatRate.getStartDate(),
                vatRate.getEndDate(),
                vatRate.getCreatedAt(),
                vatRate.getUpdatedAt()
        );
    }

    public VatRate toEntity(VatRateRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return VatRate.builder()
                .rate(dto.rate())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .description(dto.description())
                .build();
    }

    public void updateEntityFromDTO(VatRate vatRate, VatRateRequestDTO dto) {
        vatRate.setRate(dto.rate());
        vatRate.setStartDate(dto.startDate());
        vatRate.setEndDate(dto.endDate());
        vatRate.setDescription(dto.description());
    }
}
