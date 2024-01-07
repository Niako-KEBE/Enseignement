package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Définition d'une classe d'exception personnalisée nommée MaquetteException
public class MaquetteException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public MaquetteException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
