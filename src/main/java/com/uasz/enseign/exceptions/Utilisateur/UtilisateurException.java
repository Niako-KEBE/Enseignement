package com.uasz.enseign.exceptions.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
// Définition d'une classe d'exception personnalisée nommée UtilisateurException
public class UtilisateurException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public UtilisateurException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
