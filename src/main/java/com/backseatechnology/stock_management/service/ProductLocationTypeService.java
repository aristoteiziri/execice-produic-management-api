package com.backseatechnology.stock_management.service;

import com.backseatechnology.stock_management.dto.request.ProductLocationTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductLocationTypeResponseDTO;

import java.util.List;
public interface ProductLocationTypeService {
    ProductLocationTypeResponseDTO createLocationType(ProductLocationTypeRequestDTO requestDTO);
    ProductLocationTypeResponseDTO getLocationTypeById(Long id);
    List<ProductLocationTypeResponseDTO> getAllLocationTypes();
    ProductLocationTypeResponseDTO updateLocationType(Long id, ProductLocationTypeRequestDTO requestDTO);
    void deleteLocationType(Long id);
}
