package com.uasz.enseign.entities.Repartition;


import com.uasz.enseign.entities.EmploiDuTemps.Seance;
import com.uasz.enseign.exceptions.Repartition.RepartitionException;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Repartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepartition; // Identifiant auto-généré de la répartition

    @Column(nullable = false, length = 255)
    private String description; // Date de début de la répartition


    @Temporal(TemporalType.DATE)
    private Date datecreation; // Date de début de la répartition

    @Temporal(TemporalType.DATE)
    private Date dateFin; // Date de fin de la répartition

    @ManyToOne
    @JoinColumn(name = "enseignement_id") // Clé étrangère vers Enseignement
    private Enseignement enseignement;

    @ManyToOne
    @JoinColumn(name = "enseignant_id") // Clé étrangère vers Enseignant
    private Enseignant enseignant;

    @OneToMany(mappedBy = "repartition")
    private List<Seance> seances; // Liste des séances associées à cette répartition


    // Setter pour description pour validation et exception
    public void setDescription(String description) {
        // Example validation, adjust as needed
        if (description == null || description.trim().isEmpty()) {
            throw new RepartitionException("Description cannot be null or empty", "RE002");
        }

        this.description = description;
    }
}