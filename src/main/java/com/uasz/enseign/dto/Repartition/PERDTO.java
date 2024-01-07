package com.uasz.enseign.dto.Repartition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PERDTO extends EnseignantDTO {

    private String matricule;
    private String statut;
    private int anciennete;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
