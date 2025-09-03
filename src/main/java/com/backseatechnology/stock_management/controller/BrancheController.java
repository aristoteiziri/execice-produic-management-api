package com.backseatechnology.stock_management.controller;

import com.backseatechnology.stock_management.dto.request.BrancheRequestDTO;
import com.backseatechnology.stock_management.dto.response.BrancheResponseDTO;
import com.backseatechnology.stock_management.service.BrancheService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BrancheController {
    private final BrancheService brancheService;

    @PostMapping
    public ResponseEntity<BrancheResponseDTO> createBranche(@Valid @RequestBody BrancheRequestDTO requestDTO) {
        BrancheResponseDTO createdBranche = brancheService.createBranche(requestDTO);
        return new ResponseEntity<>(createdBranche, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<BrancheResponseDTO> getBrancheByCode(@PathVariable UUID code) {
        return ResponseEntity.ok(brancheService.getBrancheByCode(code));
    }

    @GetMapping
    public ResponseEntity<List<BrancheResponseDTO>> getAllBranches() {
        return ResponseEntity.ok(brancheService.getAllBranches());
    }

    @PutMapping("/{code}")
    public ResponseEntity<BrancheResponseDTO> updateBranche(@PathVariable UUID code, @Valid @RequestBody BrancheRequestDTO requestDTO) {
        return ResponseEntity.ok(brancheService.updateBranche(code, requestDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteBranche(@PathVariable UUID code) {
        brancheService.deleteBranche(code);
        return ResponseEntity.noContent().build();
    }
}
