package com.example.gestion_produit.service;

import com.example.gestion_produit.exception.NotFoundException;
import com.example.gestion_produit.model.Produit;
import com.example.gestion_produit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Produit getProduitById(long id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
       // if (produitOptional.isPresent()) return produitOptional.get();

        if(produitOptional.isEmpty()) {
            throw new NotFoundException("Produit inexistant" );
        }
        return produitOptional.get();

        // Alternatively, you can return null or an empty Optional if you prefer not to throw an exception
        // return produitRepository.findById(id).orElse(null);
        // return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit not found with id: " + id));
        // return produitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));
        // return produitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produit not found with id: " + id));
    }

    //Fonction permettant de supprimer un produit
    public String deleteProduitById(long id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        // Check if the product exists before attempting to delete
        if(produitOptional.isPresent()){
           // produitRepository.deleteById(id);
            produitRepository.delete(produitOptional.get());
            return "Produit supprimé avec succès! ";
        }else{
            throw new NotFoundException("Produit not found" );
        }

    }

    //Fonction permettant de modifier un produit
    public Produit updateProduit(long id, Produit produit) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        // Vérifier si le produit existe avant de le mettre à jour
        if(produitOptional.isPresent()) {
            Produit existingProduit = produitOptional.get();
            // Update the fields of the existing product with the new values
            existingProduit.setName(produit.getName());
            existingProduit.setPrice(produit.getPrice());
            // Add any other fields you want to update
            return produitRepository.save(existingProduit);
        } else {
            throw new NotFoundException("Produit not found");
        }



/*
        if (produitRepository.existsById(id)) {
            produit.setId(id); // Set the ID to ensure the correct product is updated
            return produitRepository.save(produit);
        } else {
            throw new RuntimeException("Produit not found with id: " + id);
        }*/
    }


}
