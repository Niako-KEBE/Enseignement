package com.uasz.enseign.dto.Repartition;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartitionDTO {

    private Long idRepartition;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private EnseignementDTO enseignement;
    private EnseignantDTO enseignant;
    private List<SeanceDTO> seances;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}

