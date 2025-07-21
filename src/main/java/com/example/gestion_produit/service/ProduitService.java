package com.example.gestion_produit.service;

import com.example.gestion_produit.model.Produit;
import com.example.gestion_produit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;


    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        // You can add any additional logic here before saving the product
        return produitRepository.save(produit);
    }

    //Fonction permettant de supprimer un produit
    public String deleteProduit(long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return "Produit with id: " + id + " deleted successfully.";
        } else {
            throw new RuntimeException("Produit not found with id: " + id);
        }
    }

    //Fonction permettant de modifier un produit
    public Produit updateProduit(long id, Produit produit) {
        if (produitRepository.existsById(id)) {
            produit.setId(id); // Set the ID to ensure the correct product is updated
            return produitRepository.save(produit);
        } else {
            throw new RuntimeException("Produit not found with id: " + id);
        }
    }


}
