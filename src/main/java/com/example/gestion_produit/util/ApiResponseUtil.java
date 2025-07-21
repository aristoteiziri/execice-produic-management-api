package com.example.gestion_produit.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponseUtil {

    /**
     * Génère une réponse HTTP 200 (OK) indiquant le succès d'une opération,
     * avec un titre, un message et des données optionnelles.
     * @param title   Titre de la réponse (ex: "Succès!")
     * @param message Message détaillant le succès
     * @param data    Données à retourner (peut être null)
     * @return        Réponse HTTP formatée avec statut 200
     */
    public static ResponseEntity<Object> successMessage(String title, String message, Object data) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", true);
        body.put("title", title != null ? title : "Succès!");
        body.put("message", message != null ? message : "Action effectuée avec succès");
        body.put("data", data != null ? data : null);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Génère une réponse HTTP 400 (Bad Request) pour signaler une erreur,
     * avec un titre et un message personnalisés.
     * @param title   Titre de l'erreur (ex: "Erreur!")
     * @param message Message d'erreur détaillé
     * @return        Réponse HTTP formatée avec statut 400
     */
    public static ResponseEntity<Object> errorMessage(String title, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", true);
        body.put("title", title != null ? title : "Erreur!");
        body.put("message", message != null ? message : "Une erreur s'est produite!");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Génère une réponse HTTP 200 (OK) pour une opération réussie,
     * avec un message et des données.
     * @param data    Données à retourner
     * @param message Message de succès
     * @return        Réponse HTTP formatée avec statut 200
     */
    public static ResponseEntity<Object> success(Object data, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "success");
        body.put("message", message);
        body.put("data", data);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Génère une réponse HTTP 201 (Created) pour signaler la création réussie d'une ressource,
     * avec un message et des données.
     * @param data    Données créées
     * @param message Message de succès
     * @return        Réponse HTTP formatée avec statut 201
     */
    public static ResponseEntity<Object> successStore(Object data, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "success");
        body.put("message", message);
        body.put("data", data);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    /**
     * Génère une réponse HTTP 500 (Internal Server Error) pour signaler une erreur serveur,
     * avec un titre et un message.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 500
     */
    public static ResponseEntity<Object> error(String title, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "error");
        body.put("title", title);
        body.put("message", message);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Génère une réponse HTTP 401 (Unauthorized) pour signaler un accès non autorisé.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 401
     */
    public static ResponseEntity<Object> unauthorized(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Génère une réponse HTTP 404 (Not Found) pour signaler qu'une ressource n'a pas été trouvée.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 404
     */
    public static ResponseEntity<Object> notFound(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.NOT_FOUND);
    }

    /**
     * Génère une réponse HTTP 409 (Conflict) pour signaler un conflit lors d'une opération.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 409
     */
    public static ResponseEntity<Object> conflict(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.CONFLICT);
    }

    /**
     * Génère une réponse HTTP 403 (Forbidden) pour signaler un accès interdit.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 403
     */
    public static ResponseEntity<Object> forbidden(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.FORBIDDEN);
    }

    /**
     * Génère une réponse HTTP 400 (Bad Request) pour signaler une requête invalide.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 400
     */
    public static ResponseEntity<Object> badRequest(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.BAD_REQUEST);
    }

    /**
     * Génère une réponse HTTP 429 (Too Many Requests) pour signaler un dépassement de quota.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 429
     */
    public static ResponseEntity<Object> tooManyRequests(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.TOO_MANY_REQUESTS);
    }

    /**
     * Génère une réponse HTTP 500 (Internal Server Error) pour signaler une erreur interne.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 500
     */
    public static ResponseEntity<Object> internalServerError(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Génère une réponse HTTP 503 (Service Unavailable) pour signaler une indisponibilité du service.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @return        Réponse HTTP formatée avec statut 503
     */
    public static ResponseEntity<Object> serviceUnavailable(String title, String message) {
        return errorWithStatus(title, message, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Génère une réponse HTTP 422 (Unprocessable Entity) pour signaler une erreur de validation,
     * en incluant les détails de l'erreur et les données invalides.
     * @param message Message d'erreur de validation
     * @param data    Données invalides
     * @param title   Titre de l'erreur
     * @return        Réponse HTTP formatée avec statut 422
     */
    public static ResponseEntity<Object> validationError(String message, Object data, String title) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "error");
        body.put("title", title);
        body.put("message", message);
        body.put("data", data);
        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Génère une réponse personnalisée avec un statut HTTP, un titre et un message.
     * @param status  Statut HTTP à retourner
     * @param title   Titre de la réponse
     * @param message Message de la réponse
     * @return        Réponse HTTP formatée avec le statut spécifié
     */
    public static ResponseEntity<Object> custom(HttpStatus status, String title, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("title", title);
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }

    /**
     * Méthode utilitaire privée pour générer une réponse d'erreur avec un statut HTTP spécifique.
     * Utilisée par les autres méthodes d'erreur pour éviter la duplication de code.
     * @param title   Titre de l'erreur
     * @param message Message d'erreur
     * @param status  Statut HTTP à retourner
     * @return        Réponse HTTP formatée avec le statut spécifié
     */
    private static ResponseEntity<Object> errorWithStatus(String title, String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "error");
        body.put("title", title);
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}