package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.CurrencyRequestDTO;
import com.backseatechnology.stock_management.dto.response.CurrencyResponseDTO;
import com.backseatechnology.stock_management.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {
    public CurrencyResponseDTO toResponseDTO(Currency currency) {
        if (currency == null) {
            return null;
        }
        return new CurrencyResponseDTO(
                currency.getId(),
                currency.getName(),
                currency.getCode()
        );
    }

    public Currency toEntity(CurrencyRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Currency.builder()
                .name(dto.name())
                .code(dto.code())
                .build();
    }
}
