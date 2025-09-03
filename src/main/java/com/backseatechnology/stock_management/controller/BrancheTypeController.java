package com.backseatechnology.stock_management.controller;

import com.backseatechnology.stock_management.dto.request.BrancheTypeRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheTypeResponseDTO;
import com.backseatechnology.stock_management.service.BrancheTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/branche-types")
@RequiredArgsConstructor
public class BrancheTypeController {

    private final BrancheTypeService brancheTypeService;

    @PostMapping
    public ResponseEntity<BrancheTypeResponseDTO> createBrancheType(@Valid @RequestBody BrancheTypeRequestDTO requestDTO) {
        BrancheTypeResponseDTO createdBrancheType = brancheTypeService.createBrancheType(requestDTO);
        return new ResponseEntity<>(createdBrancheType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrancheTypeResponseDTO> getBrancheTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(brancheTypeService.getBrancheTypeById(id));
    }



    @GetMapping
    public ResponseEntity<List<BrancheTypeResponseDTO>> getAllBrancheTypes() {
        return ResponseEntity.ok(brancheTypeService.getAllBrancheTypes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrancheTypeResponseDTO> updateBrancheType(@PathVariable Long id, @Valid @RequestBody BrancheTypeRequestDTO requestDTO) {
        return ResponseEntity.ok(brancheTypeService.updateBrancheType(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrancheType(@PathVariable Long id) {
        brancheTypeService.deleteBrancheType(id);
        return ResponseEntity.noContent().build();
    }
}
