package com.example.gestion_produit.dto;



import jakarta.validation.constraints.*;

public class ProduitCreateDto {
    @NotBlank(message = "Le nom du produit est obligatoire.")
    @Size(min = 3, max = 100, message = "Le nom du produit doit comporter entre 3 et 100 caractères.")
    private String nom;

    @NotNull(message = "Le prix est obligatoire.")
    @Positive(message = "Le prix doit être positif.")
    @DecimalMin(value = "0.01", message = "Le prix doit être supérieur à 0.")
    @DecimalMax(value = "10000.00", message = "Le prix ne doit pas dépasser 10 000.")
    private Double prix;

        // getters et setters
    }

