package com.backseatechnology.stock_management.controller;
import com.backseatechnology.stock_management.dto.request.CommercialUnitRequestDTO;
import com.backseatechnology.stock_management.dto.response.CommercialUnitResponseDTO;
import com.backseatechnology.stock_management.service.CommercialUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commercial-units")
@RequiredArgsConstructor
public class CommercialUnitController {

    private final CommercialUnitService unitService;

    @PostMapping
    public ResponseEntity<CommercialUnitResponseDTO> createUnit(@Valid @RequestBody CommercialUnitRequestDTO requestDTO) {
        return new ResponseEntity<>(unitService.createUnit(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommercialUnitResponseDTO> getUnitById(@PathVariable Long id) {
        return ResponseEntity.ok(unitService.getUnitById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommercialUnitResponseDTO>> getAllUnits() {
        return ResponseEntity.ok(unitService.getAllUnits());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommercialUnitResponseDTO> updateUnit(@PathVariable Long id, @Valid @RequestBody CommercialUnitRequestDTO requestDTO) {
        return ResponseEntity.ok(unitService.updateUnit(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}
