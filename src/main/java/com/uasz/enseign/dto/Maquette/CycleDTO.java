package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CycleDTO {

    private Long idCycle;
    private String libelle;
    private String description;
    private Date dateCreation;
    private List<NiveauDTO> niveaux;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
