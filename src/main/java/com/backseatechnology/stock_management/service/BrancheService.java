package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.BrancheRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheResponseDTO;

import java.util.List;
import java.util.UUID;
public interface BrancheService {
    BrancheResponseDTO createBranche(BrancheRequestDTO requestDTO);
    BrancheResponseDTO getBrancheByCode(UUID code);
    List<BrancheResponseDTO> getAllBranches();
    BrancheResponseDTO updateBranche(UUID code, BrancheRequestDTO requestDTO);
    void deleteBranche(UUID code);
}
