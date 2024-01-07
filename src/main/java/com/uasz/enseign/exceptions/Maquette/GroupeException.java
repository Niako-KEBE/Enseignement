package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Définition d'une classe d'exception personnalisée nommée GroupeException
public class GroupeException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public GroupeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
