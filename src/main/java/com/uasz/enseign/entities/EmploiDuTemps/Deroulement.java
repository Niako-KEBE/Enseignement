package com.uasz.enseign.entities.EmploiDuTemps;

import com.uasz.enseign.exceptions.EmploiDuTemps.DeroulementException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deroulement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeroulement; // Identifiant auto-généré du déroulement

    @Column(nullable = false, length = 100)
    private String objectifs; // Objectifs du déroulement

    @Column(length = 255)
    private String description; // Description du déroulement

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation; // Date de création du déroulement


    // Relation OneToOne avec l'entité Seance
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;

    // Ajoutez des méthodes ou des validations nécessitant la gestion de DeroulementException
    public void validateObjectifs() {
        if (objectifs == null || objectifs.isEmpty()) {
            throw new DeroulementException("Les objectifs du déroulement ne peuvent pas être vides.", "DE001");
        }
    }

}
