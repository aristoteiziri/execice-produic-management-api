package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.CommercialUnitRequestDTO;
import com.backseatechnology.stock_management.dto.response.CommercialUnitResponseDTO;
import java.util.List;
public interface CommercialUnitService {
    CommercialUnitResponseDTO createUnit(CommercialUnitRequestDTO requestDTO);
    CommercialUnitResponseDTO getUnitById(Long id);
    List<CommercialUnitResponseDTO> getAllUnits();
    CommercialUnitResponseDTO updateUnit(Long id, CommercialUnitRequestDTO requestDTO);
    void deleteUnit(Long id);
}
