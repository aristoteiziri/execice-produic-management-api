package com.example.gestion_produit.controller;



import com.example.gestion_produit.model.Produit;
import com.example.gestion_produit.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable long id) {
        return produitService.getProduitById(id);
    }


    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    @PatchMapping("/update/{id}")
    public Produit updateProduit(@PathVariable long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduitById(@PathVariable long id) {
       return produitService.deleteProduitById(id);
    }
}
