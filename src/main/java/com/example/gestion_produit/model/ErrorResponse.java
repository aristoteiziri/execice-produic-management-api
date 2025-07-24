package com.example.gestion_produit.model;

public record ErrorResponse(int status, String message) {
    // This record class is used to represent an error response with a status code and a message.
    // It can be used in exception handling to return structured error information.
}
