package com.uasz.enseign.entities.EmploiDuTemps;

import com.uasz.enseign.exceptions.EmploiDuTemps.SalleException;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private int capacite;

    @Column(length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances;

    @ManyToOne
    @JoinColumn(name = "batiment_id") // Nom de la colonne de la clé étrangère
    private Batiment batiment;

    // Example method demonstrating the use of SalleException
    public void validateSalle() {
        // Replace the condition with your actual validation logic
        if (capacite <= 0) {
            throw new SalleException("La capacité de la salle doit être supérieure à zéro.", "SAL001");
        }

        // Add more validations as needed...
    }

}

