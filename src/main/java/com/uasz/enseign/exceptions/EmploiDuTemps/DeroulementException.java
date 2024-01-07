package com.uasz.enseign.exceptions.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Définition d'une classe d'exception personnalisée nommée DeroulementException
public class DeroulementException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public DeroulementException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
