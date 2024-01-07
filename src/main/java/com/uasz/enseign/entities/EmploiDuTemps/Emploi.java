package com.uasz.enseign.entities.EmploiDuTemps;

import com.uasz.enseign.exceptions.EmploiDuTemps.EmploiException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploi; // Identifiant auto-généré de l'emploi du temps

    @Column(nullable = false)
    private int duree; // Durée de l'emploi du temps en minutes

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date debut; // Heure de début de l'emploi du temps

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date fin; // Heure de fin de l'emploi du temps

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation; // Date de création de l'emploi du temps

    // Relation OneToMany avec l'entité Seance
    @OneToMany(mappedBy = "emploi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances; // Liste des séances associées à cet emploi du temps

    // Example method demonstrating the use of EmploiException
    public void validateEmploi() {
        // Replace the condition with your actual validation logic
        if (duree <= 0) {
            throw new EmploiException("La durée de l'emploi du temps doit être supérieure à zéro.", "EMP001");
        }

    }

}