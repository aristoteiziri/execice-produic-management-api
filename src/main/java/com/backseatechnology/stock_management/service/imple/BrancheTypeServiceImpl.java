package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.service.BrancheTypeService;

import com.backseatechnology.stock_management.dto.request.BrancheTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheTypeResponseDTO;
import com.backseatechnology.stock_management.entity.BrancheType;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.BrancheTypeMapper;
import com.backseatechnology.stock_management.repository.BrancheTypeRepository;
import com.backseatechnology.stock_management.service.BrancheTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrancheTypeServiceImpl implements BrancheTypeService {

    private final BrancheTypeRepository brancheTypeRepository;
    private final BrancheTypeMapper brancheTypeMapper;

    @Override
    @Transactional
    public BrancheTypeResponseDTO createBrancheType(BrancheTypeRequestDTO requestDTO) {
        brancheTypeRepository.findByName(requestDTO.name()).ifPresent(bt -> {
            throw new IllegalArgumentException("A branch type with the name '" + requestDTO.name() + "' already exists.");
        });

        BrancheType brancheType = brancheTypeMapper.toEntity(requestDTO);
        BrancheType savedBrancheType = brancheTypeRepository.save(brancheType);
        return brancheTypeMapper.toResponseDTO(savedBrancheType);
    }

    @Override
    @Transactional(readOnly = true)
    public BrancheTypeResponseDTO getBrancheTypeById(Long id) {
        BrancheType brancheType = brancheTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BrancheType", "id", id));
        return brancheTypeMapper.toResponseDTO(brancheType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BrancheTypeResponseDTO> getAllBrancheTypes() {
        return brancheTypeRepository.findAll().stream()
                .map(brancheTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BrancheTypeResponseDTO updateBrancheType(Long id, BrancheTypeRequestDTO requestDTO) {
        BrancheType existingBrancheType = brancheTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BrancheType", "id", id));

        brancheTypeRepository.findByName(requestDTO.name()).ifPresent(bt -> {
            if (!bt.getId().equals(id)) {
                throw new IllegalArgumentException("A branch type with the name '" + requestDTO.name() + "' already exists.");
            }
        });

        existingBrancheType.setName(requestDTO.name());
        BrancheType updatedBrancheType = brancheTypeRepository.save(existingBrancheType);
        return brancheTypeMapper.toResponseDTO(updatedBrancheType);
    }

    @Override
    @Transactional
    public void deleteBrancheType(Long id) {
        BrancheType brancheType = brancheTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BrancheType", "id", id));

        // Règle métier importante : Ne pas supprimer un type s'il est utilisé par des branches
        if (brancheType.getBranches() != null && !brancheType.getBranches().isEmpty()) {
            throw new IllegalStateException("Cannot delete branch type '" + brancheType.getName() + "' because it is currently assigned to one or more branches.");
        }

        brancheTypeRepository.delete(brancheType);
    }
}
