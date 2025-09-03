package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.service.BrancheService;

import com.backseatechnology.stock_management.dto.request.BrancheRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheResponseDTO;
import com.backseatechnology.stock_management.entity.Branche;
import com.backseatechnology.stock_management.entity.BrancheType;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.BrancheMapper;
import com.backseatechnology.stock_management.repository.BrancheRepository;
import com.backseatechnology.stock_management.repository.BrancheTypeRepository;
import com.backseatechnology.stock_management.service.BrancheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Injection de dépendances via le constructeur
public class BrancheServiceImpl implements BrancheService {
    private final BrancheRepository brancheRepository;
    private final BrancheTypeRepository brancheTypeRepository;
    private final BrancheMapper brancheMapper;

    @Override
    @Transactional
    public BrancheResponseDTO createBranche(BrancheRequestDTO requestDTO) {
        // Vérifier si une branche avec le même nom existe déjà
        brancheRepository.findByName(requestDTO.name()).ifPresent(b -> {
            throw new IllegalArgumentException("A branch with the name '" + requestDTO.name() + "' already exists.");
        });

        // Récupérer le type de branche
        BrancheType brancheType = brancheTypeRepository.findById(requestDTO.brancheTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("BrancheType", "id", requestDTO.brancheTypeId()));

        // Mapper le DTO en entité
        Branche branche = brancheMapper.toEntity(requestDTO, brancheType);

        // Sauvegarder l'entité
        Branche savedBranche = brancheRepository.save(branche);

        // Retourner le DTO de réponse
        return brancheMapper.toResponseDTO(savedBranche);
    }

    @Override
    @Transactional(readOnly = true)
    public BrancheResponseDTO getBrancheByCode(UUID code) {
        Branche branche = brancheRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Branche", "code", code));
        return brancheMapper.toResponseDTO(branche);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BrancheResponseDTO> getAllBranches() {
        return brancheRepository.findAll().stream()
                .map(brancheMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BrancheResponseDTO updateBranche(UUID code, BrancheRequestDTO requestDTO) {
        Branche existingBranche = brancheRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Branche", "code", code));

        // Vérifier si le nouveau nom est déjà pris par une autre branche
        brancheRepository.findByName(requestDTO.name()).ifPresent(b -> {
            if (!b.getCode().equals(code)) {
                throw new IllegalArgumentException("A branch with the name '" + requestDTO.name() + "' already exists.");
            }
        });

        BrancheType brancheType = brancheTypeRepository.findById(requestDTO.brancheTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("BrancheType", "id", requestDTO.brancheTypeId()));

        // Mettre à jour l'entité existante avec les nouvelles données
        brancheMapper.updateEntityFromDTO(existingBranche, requestDTO, brancheType);

        Branche updatedBranche = brancheRepository.save(existingBranche);
        return brancheMapper.toResponseDTO(updatedBranche);
    }

    @Override
    @Transactional
    public void deleteBranche(UUID code) {
        Branche branche = brancheRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Branche", "code", code));
        brancheRepository.delete(branche);
    }
}
