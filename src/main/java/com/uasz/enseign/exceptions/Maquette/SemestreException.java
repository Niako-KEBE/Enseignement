package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// Définition d'une classe d'exception personnalisée nommée SemestreException
public class SemestreException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public SemestreException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
