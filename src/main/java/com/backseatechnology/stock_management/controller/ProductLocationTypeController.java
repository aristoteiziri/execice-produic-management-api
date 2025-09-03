package com.backseatechnology.stock_management.controller;
import com.backseatechnology.stock_management.dto.request.ProductLocationTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.ProductLocationTypeResponseDTO;
import com.backseatechnology.stock_management.service.ProductLocationTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-location-types")
@RequiredArgsConstructor
public class ProductLocationTypeController {
    private final ProductLocationTypeService locationTypeService;

    @PostMapping
    public ResponseEntity<ProductLocationTypeResponseDTO> createLocationType(@Valid @RequestBody ProductLocationTypeRequestDTO requestDTO) {
        ProductLocationTypeResponseDTO createdType = locationTypeService.createLocationType(requestDTO);
        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductLocationTypeResponseDTO> getLocationTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(locationTypeService.getLocationTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductLocationTypeResponseDTO>> getAllLocationTypes() {
        return ResponseEntity.ok(locationTypeService.getAllLocationTypes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductLocationTypeResponseDTO> updateLocationType(@PathVariable Long id, @Valid @RequestBody ProductLocationTypeRequestDTO requestDTO) {
        return ResponseEntity.ok(locationTypeService.updateLocationType(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationType(@PathVariable Long id) {
        locationTypeService.deleteLocationType(id);
        return ResponseEntity.noContent().build();
    }
}
