package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
// Définition d'une classe d'exception personnalisée nommée ModuleException
public class ModuleException extends RuntimeException {

    private String errorCode;

    // Constructeur avec un message d'erreur et un code d'erreur spécifique
    public ModuleException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
