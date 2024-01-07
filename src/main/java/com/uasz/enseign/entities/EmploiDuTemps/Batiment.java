package com.uasz.enseign.entities.EmploiDuTemps;

import com.uasz.enseign.exceptions.EmploiDuTemps.BatimentException;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Batiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String position;

    @Column(length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation;

    // Relation OneToMany avec l'entité Salle
    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salle> salles;


    // Ajoutez des méthodes ou des validations nécessitant la gestion de BatimentException
    public void validateLibelle() {
        if (libelle == null || libelle.isEmpty()) {
            throw new BatimentException("Le libellé du bâtiment ne peut pas être vide.", "BE001");
        }
    }

    public void validateCode() {
        if (code == null || code.isEmpty()) {
            throw new BatimentException("Le code du bâtiment ne peut pas être vide.", "BE002");
        }
    }

}
