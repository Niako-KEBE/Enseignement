package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereDTO {

    private Long idFiliere;
    private String libelle;
    private String description;
    private Date dateCreation;
    private List<FormationDTO> formations;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
