package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// Définition d'une classe d'exception personnalisée nommée NiveauException
public class NiveauException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public NiveauException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
