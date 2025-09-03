package com.backseatechnology.stock_management.utils.services;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.regex.Pattern;


/**
 * Classe utilitaire pour les opérations sur les chaînes de caractères.
 * Cette classe ne peut pas être instanciée.
 */
public final class StringServiceUtil {
    private static final Pattern DIACRITICAL_MARKS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe utilitaire.
     */
    private StringServiceUtil() {}

    /**
     * Supprime les accents d'une chaîne de caractères et la convertit en minuscules.
     *
     * @param str La chaîne de caractères à traiter.
     * @return La chaîne sans accents et en minuscules, ou null si l'entrée est nulle ou vide.
     */
    public static String removeAccentsAndLowercase(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        // Sépare les caractères de leurs marques diacritiques (accents)
        String normalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        // Supprime les marques diacritiques
        String withoutAccents = DIACRITICAL_MARKS_PATTERN.matcher(normalizedString).replaceAll("");
        return withoutAccents.toLowerCase();
    }

    /**
     * Convertit la première lettre d'une chaîne en majuscule et le reste en minuscule,
     * en tenant compte des accents.
     *
     * @param str La chaîne à transformer.
     * @return La chaîne modifiée, ou null si l'entrée est nulle.
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // Convertit toute la chaîne en minuscules
        String lowerCaseString = str.toLowerCase();
        // Récupère le premier caractère
        String firstChar = lowerCaseString.substring(0, 1);
        // Met le premier caractère en majuscule et le concatène avec le reste
        return firstChar.toUpperCase() + lowerCaseString.substring(1);
    }

    /**
     * Convertit la première lettre de chaque mot d'une chaîne en majuscule.
     * Les mots sont délimités par des espaces.
     *
     * @param str La chaîne à transformer.
     * @return La chaîne modifiée, ou null si l'entrée est nulle.
     */
    public static String capitalizeEachWord(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        // Sépare la chaîne en mots, met en majuscule la première lettre de chaque mot, puis les rejoint
        return Arrays.stream(str.trim().split("\\s+")) // \\s+ pour gérer les espaces multiples
                .map(StringServiceUtil::capitalizeFirstLetter)
                .collect(Collectors.joining(" "));
    }

    /**
     * Met en majuscule la première lettre de chaque mot, avec une gestion spéciale pour les tirets.
     * Par exemple, "jean-claude" devient "Jean-Claude".
     *
     * @param str La chaîne à transformer.
     * @return La chaîne modifiée, ou null si l'entrée est nulle.
     */
    public static String capitalizeEachWordSpecial(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        String lowerCaseString = str.toLowerCase();

        // Traite les mots séparés par des espaces
        return Arrays.stream(lowerCaseString.split(" "))
                .map(word -> {
                    // Traite les sous-mots séparés par des tirets
                    return Arrays.stream(word.split("-"))
                            .map(StringServiceUtil::capitalizeFirstLetter)
                            .collect(Collectors.joining("-"));
                })
                .collect(Collectors.joining(" "));
    }
}
