package com.example.gestion_produit.model;

import jakarta.persistence.*; // import jakarta.persistence.Entity;


import lombok.*;// import lombok.AllArgsConstructor;

@Entity //Permet de dire que la classe est une entité JPA
@AllArgsConstructor //Permet de générer le constructeur avec tous les parametres de la classe
@NoArgsConstructor //Permet de générer le constructeur sans parametres de la classe
@Getter //Permet de générer les getters de la classe
@Setter //Permet de générer les getters et setters de la classe
@Builder //Permet de générer le pattern Builder de la classe
@Table(name = "produits")
public class Produit {
    @Id //Permet de dire que l'attribut id est la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Permet de générer l'ID automatiquement
    private long id;
    private String name; //
    private double price; //
}