package com.uasz.enseign.dto.Maquette;

import com.uasz.enseign.dto.Repartition.EnseignementDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasseDTO {

    private Long idClasse;
    private String libelle;
    private int effectif;
    private int nbreGroupe;
    private String description;
    private Date dateCreation;
    private SemestreDTO semestre; // Utilisation du DTO correspondant à Semestre
    private FormationDTO formation; // Utilisation du DTO correspondant à Formation
    private List<GroupeDTO> groupes;
    private List<EnseignementDTO> enseignements;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
