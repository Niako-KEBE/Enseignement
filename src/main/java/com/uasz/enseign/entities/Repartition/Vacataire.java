package com.uasz.enseign.entities.Repartition;

import com.uasz.enseign.exceptions.Repartition.VacataireException;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VAC") // Valeur du type pour l'enseignant vacataire
public class Vacataire extends Enseignant {

    @Column(nullable = false)
    private String specialite; // Attribut spécifique à l'enseignant permanent

    @Column(nullable = false)
    private String contrat; // Attribut spécifique à l'enseignant vacataire

    @Column(nullable = false)
    private int heuresEnseignement; // Attribut spécifique à l'enseignant vacataire


    //Methode de validation
    public void validateSpecialite() {
        if (specialite == null || specialite.isEmpty()) {
            throw new VacataireException("La spécialité ne peut pas être vide", "VAC001");
        }
        // Ajoutez d'autres validations au besoin...
    }

    public void validateContrat() {
        if (contrat == null || contrat.isEmpty()) {
            throw new VacataireException("Le contrat ne peut pas être vide", "VAC002");
        }
        // Ajoutez d'autres validations au besoin...
    }

    public void validateHeuresEnseignement() {
        if (heuresEnseignement <= 0) {
            throw new VacataireException("Le nombre d'heures d'enseignement doit être positif", "VAC003");
        }
    }
}