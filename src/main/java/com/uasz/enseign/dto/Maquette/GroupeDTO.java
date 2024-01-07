package com.uasz.enseign.dto.Maquette;

import com.uasz.enseign.dto.Repartition.EnseignementDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupeDTO {

    private Long idGroupe;
    private String libelle;
    private int numero;
    private int effectif;
    private String description;
    private Date dateCreation;
    private ClasseDTO classe; // Utilisation du DTO correspondant à Classe
    private Collection<EnseignementDTO> enseignements;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
