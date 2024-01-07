package com.uasz.enseign.exceptions.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// Définition d'une classe d'exception personnalisée nommée BatimentException
public class BatimentException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public BatimentException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
