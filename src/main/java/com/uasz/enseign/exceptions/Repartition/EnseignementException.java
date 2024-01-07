package com.uasz.enseign.exceptions.Repartition;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
// Définition d'une classe d'exception personnalisée nommée EnseignementException
public class EnseignementException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public EnseignementException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
