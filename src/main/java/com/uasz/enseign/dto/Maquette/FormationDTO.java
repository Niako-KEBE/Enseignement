package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {

    private Long idFormation;
    private String libelle;
    private String description;
    private Date dateCreation;
    private NiveauDTO niveau; // Utilisation du DTO correspondant à Niveau
    private FiliereDTO filiere; // Utilisation du DTO correspondant à Filiere
    private MaquetteDTO maquette; // Utilisation du DTO correspondant à Maquette
    private List<ClasseDTO> classes;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
