package com.backseatechnology.stock_management.service.imple;

import com.backseatechnology.stock_management.dto.request.CommercialUnitRequestDTO;
import com.backseatechnology.stock_management.dto.response.CommercialUnitResponseDTO;
import com.backseatechnology.stock_management.entity.CommercialUnit;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.CommercialUnitMapper;
import com.backseatechnology.stock_management.repository.CommercialUnitRepository;
import com.backseatechnology.stock_management.service.CommercialUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommercialUnitServiceImpl implements CommercialUnitService {

    private final CommercialUnitRepository unitRepository;
    private final CommercialUnitMapper unitMapper;

    @Override
    @Transactional
    public CommercialUnitResponseDTO createUnit(CommercialUnitRequestDTO requestDTO) {
        validateUniqueness(requestDTO.name(), requestDTO.abbreviation(), null);
        CommercialUnit unit = unitMapper.toEntity(requestDTO);
        CommercialUnit savedUnit = unitRepository.save(unit);
        return unitMapper.toResponseDTO(savedUnit);
    }

    @Override
    @Transactional
    public CommercialUnitResponseDTO updateUnit(Long id, CommercialUnitRequestDTO requestDTO) {
        CommercialUnit existingUnit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommercialUnit", "id", id));
        validateUniqueness(requestDTO.name(), requestDTO.abbreviation(), id);
        unitMapper.updateEntityFromDTO(existingUnit, requestDTO);
        CommercialUnit updatedUnit = unitRepository.save(existingUnit);
        return unitMapper.toResponseDTO(updatedUnit);
    }

    @Override
    @Transactional
    public void deleteUnit(Long id) {
        CommercialUnit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommercialUnit", "id", id));
        if (unit.getProducts() != null && !unit.getProducts().isEmpty()) {
            throw new IllegalStateException("Cannot delete unit '" + unit.getName() + "' because it is in use by products.");
        }
        unitRepository.delete(unit);
    }

    // Méthodes de lecture
    @Override
    @Transactional(readOnly = true)
    public CommercialUnitResponseDTO getUnitById(Long id) {
        return unitRepository.findById(id).map(unitMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("CommercialUnit", "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommercialUnitResponseDTO> getAllUnits() {
        return unitRepository.findAll().stream().map(unitMapper::toResponseDTO).collect(Collectors.toList());
    }

    // Méthode de validation privée
    private void validateUniqueness(String name, String abbreviation, Long excludedId) {
        unitRepository.findByName(name).ifPresent(u -> {
            if (excludedId == null || !u.getId().equals(excludedId)) {
                throw new IllegalArgumentException("A unit with the name '" + name + "' already exists.");
            }
        });
        if (abbreviation != null && !abbreviation.isBlank()) {
            unitRepository.findByAbbreviation(abbreviation).ifPresent(u -> {
                if (excludedId == null || !u.getId().equals(excludedId)) {
                    throw new IllegalArgumentException("A unit with the abbreviation '" + abbreviation + "' already exists.");
                }
            });
        }
    }
}
