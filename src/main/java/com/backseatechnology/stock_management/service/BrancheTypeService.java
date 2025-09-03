package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.BrancheTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheTypeResponseDTO;

import java.util.List;
public interface BrancheTypeService {
    BrancheTypeResponseDTO createBrancheType(BrancheTypeRequestDTO requestDTO);
    BrancheTypeResponseDTO getBrancheTypeById(Long id);
    List<BrancheTypeResponseDTO> getAllBrancheTypes();
    BrancheTypeResponseDTO updateBrancheType(Long id, BrancheTypeRequestDTO requestDTO);
    void deleteBrancheType(Long id);
}
