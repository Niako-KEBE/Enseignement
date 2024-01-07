package com.uasz.enseign.entities.EmploiDuTemps;

import com.uasz.enseign.entities.Repartition.Repartition;
import com.uasz.enseign.exceptions.EmploiDuTemps.SeanceException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeance; // Identifiant de la séance

    @Column(nullable = false)
    private String jour; // Jour de la semaine de la séance

    @Column(nullable = false)
    private int duree; // Durée de la séance en minutes

    @Column(nullable = false)
    private String debut; // Heure de début de la séance au format HH:mm

    @Column(nullable = false)
    private String fin; // Heure de fin de la séance au format HH:mm

    @Column(nullable = false)
    private int numero; // Numéro de la séance dans la journée

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation; // Date de création de la séance

    @ManyToOne
    @JoinColumn(name = "repartition_id") // Nom de la colonne de la clé étrangère
    private Repartition repartition; // La répartition associée à cette séance

    // Relation ManyToOne avec l'entité Emploi
    @ManyToOne
    @JoinColumn(name = "emploi_id") // Nom de la colonne de la clé étrangère
    private Emploi emploi; // L'emploi du temps associé à cette séance


    // Relation OneToOne avec l'entité Deroulement
    @OneToOne(mappedBy = "seance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Deroulement deroulement;

    @ManyToOne
    @JoinColumn(name = "salle_id") // Nom de la colonne de la clé étrangère
    private Salle salle;

    public void validateSeance() {
        // Replace the condition with your actual validation logic
        if (duree <= 0) {
            throw new SeanceException("La durée de la séance doit être supérieure à zéro.", "SEA001");
        }

        // Add more validations as needed...
    }
}
