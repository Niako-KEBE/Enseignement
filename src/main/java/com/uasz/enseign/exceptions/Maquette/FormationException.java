package com.uasz.enseign.exceptions.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FormationException extends RuntimeException {

    private String errorCode;

    public FormationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
