package com.example.gestion_produit.repository;

import com.example.gestion_produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
