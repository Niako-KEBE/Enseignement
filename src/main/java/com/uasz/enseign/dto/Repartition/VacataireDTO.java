package com.uasz.enseign.dto.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacataireDTO extends EnseignantDTO {

    private String specialite;
    private String contrat;
    private int heuresEnseignement;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
