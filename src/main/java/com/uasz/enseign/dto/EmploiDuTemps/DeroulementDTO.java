package com.uasz.enseign.dto.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeroulementDTO {

    private Long idDeroulement;
    private String objectifs;
    private String description;
    private Date dateCreation;
    private SeanceDTO seance;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
