package com.uasz.enseign.dto.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EnseignantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String grade;
}


