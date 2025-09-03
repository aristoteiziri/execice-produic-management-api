package com.backseatechnology.stock_management.mapper;

import com.backseatechnology.stock_management.dto.request.BrancheRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheResponseDTO;
import com.backseatechnology.stock_management.dto.response.BrancheTypeResponseDTO; // Assurez-vous d'avoir ce DTO
import com.backseatechnology.stock_management.entity.Branche;
import com.backseatechnology.stock_management.entity.BrancheType;
import org.springframework.stereotype.Component;
public class BrancheMapper {
    public BrancheResponseDTO toResponseDTO(Branche branche) {
        if (branche == null) {
            return null;
        }

        BrancheTypeResponseDTO brancheTypeDTO = null;
        if (branche.getBrancheType() != null) {
            brancheTypeDTO = new BrancheTypeResponseDTO(
                    branche.getBrancheType().getId(),
                    branche.getBrancheType().getName(),
                    branche.getBrancheType().getCreatedAt(),
                    branche.getBrancheType().getUpdatedAt()
            );
        }

        return new BrancheResponseDTO(
                branche.getCode(),
                branche.getName(),
                branche.getPhone(),
                branche.getDescription(),
                branche.getEmail(),
                branche.getCommercialRegister(),
                branche.getFiscalIdentifier(),
                branche.getAddress(),
                branche.getCity(),
                branche.getState(),
                branche.getStatus(),
                brancheTypeDTO,
                branche.getCreatedAt(),
                branche.getUpdatedAt()
        );
    }

    public Branche toEntity(BrancheRequestDTO dto, BrancheType brancheType) {
        if (dto == null) {
            return null;
        }

        return Branche.builder()
                .name(dto.name())
                .phone(dto.phone())
                .description(dto.description())
                .email(dto.email())
                .commercialRegister(dto.commercialRegister())
                .fiscalIdentifier(dto.fiscalIdentifier())
                .address(dto.address())
                .city(dto.city())
                .state(dto.state())
                .brancheType(brancheType) // Set the managed entity
                .status(dto.status() != null ? dto.status() : com.backseatechnology.stock_management.utils.enums.branche.BrancheStatusEnum.ACTIVE)
                .build();
    }

    public void updateEntityFromDTO(Branche branche, BrancheRequestDTO dto, BrancheType brancheType) {
        branche.setName(dto.name());
        branche.setPhone(dto.phone());
        branche.setDescription(dto.description());
        branche.setEmail(dto.email());
        branche.setCommercialRegister(dto.commercialRegister());
        branche.setFiscalIdentifier(dto.fiscalIdentifier());
        branche.setAddress(dto.address());
        branche.setCity(dto.city());
        branche.setState(dto.state());
        branche.setBrancheType(brancheType);
        if (dto.status() != null) {
            branche.setStatus(dto.status());
        }
    }
}
