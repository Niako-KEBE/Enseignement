package com.uasz.enseign.exceptions.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// Définition d'une classe d'exception personnalisée nommée RepartitionException
public class RepartitionException extends RuntimeException {

    private String errorCode;


    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public RepartitionException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
