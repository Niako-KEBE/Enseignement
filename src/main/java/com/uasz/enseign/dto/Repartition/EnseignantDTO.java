package com.uasz.enseign.dto.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EnseignantDTO {

    private Long idEnseignant;
    private String nom;
    private String prenom;
    private String email;
    private Date dateCreation;
    private String adresse;
    private String telephone;
    private String grade;

}

