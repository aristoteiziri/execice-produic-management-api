package com.backseatechnology.stock_management.service.imple;


import com.backseatechnology.stock_management.dto.request.ProductLocationTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductLocationTypeResponseDTO;
import com.backseatechnology.stock_management.entity.ProductLocationType;
import com.backseatechnology.stock_management.exception.ResourceNotFoundException;
import com.backseatechnology.stock_management.mapper.ProductLocationTypeMapper;
import com.backseatechnology.stock_management.repository.ProductLocationTypeRepository;
import com.backseatechnology.stock_management.service.ProductLocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductLocationTypeServiceImpl implements ProductLocationTypeService {

    private final ProductLocationTypeRepository locationTypeRepository;
    private final ProductLocationTypeMapper locationTypeMapper;

    @Override
    @Transactional
    public ProductLocationTypeResponseDTO createLocationType(ProductLocationTypeRequestDTO requestDTO) {
        locationTypeRepository.findByName(requestDTO.name()).ifPresent(type -> {
            throw new IllegalArgumentException("A location type with the name '" + requestDTO.name() + "' already exists.");
        });

        ProductLocationType locationType = locationTypeMapper.toEntity(requestDTO);
        ProductLocationType savedLocationType = locationTypeRepository.save(locationType);
        return locationTypeMapper.toResponseDTO(savedLocationType);
    }

    @Override
    @Transactional
    public ProductLocationTypeResponseDTO updateLocationType(Long id, ProductLocationTypeRequestDTO requestDTO) {
        ProductLocationType existingType = locationTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLocationType", "id", id));

        locationTypeRepository.findByName(requestDTO.name()).ifPresent(type -> {
            if (!type.getId().equals(id)) {
                throw new IllegalArgumentException("A location type with the name '" + requestDTO.name() + "' already exists.");
            }
        });

        locationTypeMapper.updateEntityFromDTO(existingType, requestDTO);
        ProductLocationType updatedType = locationTypeRepository.save(existingType);
        return locationTypeMapper.toResponseDTO(updatedType);
    }

    @Override
    @Transactional
    public void deleteLocationType(Long id) {
        ProductLocationType locationType = locationTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLocationType", "id", id));

        // Règle métier : Ne pas supprimer un type s'il est utilisé
        if (locationType.getProductLocations() != null && !locationType.getProductLocations().isEmpty()) {
            throw new IllegalStateException("Cannot delete location type '" + locationType.getName() + "' because it is in use.");
        }

        locationTypeRepository.delete(locationType);
    }

    // Méthodes de lecture
    @Override
    @Transactional(readOnly = true)
    public ProductLocationTypeResponseDTO getLocationTypeById(Long id) {
        return locationTypeRepository.findById(id)
                .map(locationTypeMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLocationType", "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductLocationTypeResponseDTO> getAllLocationTypes() {
        return locationTypeRepository.findAll().stream()
                .map(locationTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
