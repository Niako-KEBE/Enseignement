package com.uasz.enseign.entities.Repartition;

import com.uasz.enseign.exceptions.Repartition.PERException;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PER") // Valeur du type pour l'enseignant permanent
public class PER extends Enseignant {

    @Column(nullable = false)
    private String matricule; // Attribut spécifique à l'enseignant permanent

    @Column(nullable = false)
    private String statut; // Attribut spécifique à l'enseignant permanent

    @Column(nullable = false)
    private int anciennete; // Ajout d'un attribut spécifique à l'enseignant permanent

    public void setMatricule(String matricule) {
        // Validation et gestion d'exception pour l'attribut matricule
        if (matricule == null || matricule.trim().isEmpty()) {
            throw new PERException("Matricule de l'enseignant permanent ne peut pas être vide.", "EX010");
        }
        this.matricule = matricule;
    }

}