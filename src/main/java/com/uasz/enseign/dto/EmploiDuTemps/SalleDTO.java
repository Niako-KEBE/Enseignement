package com.uasz.enseign.dto.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleDTO {

    private Long idSalle;
    private String libelle;
    private String code;
    private int capacite;
    private String description;
    private Date dateCreation;
    private List<SeanceDTO> seances;
    private BatimentDTO batiment;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
