package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.NiveauException;
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
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau; // Identifiant auto-généré du niveau

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé du niveau

    @Column(length = 255)
    private String description; // Description du niveau

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création du niveau

    // Relation ManyToOne avec l'entité Cycle
    @ManyToOne
    @JoinColumn(name = "cycle_id") // Nom de la colonne de la clé étrangère
    private Cycle cycle; // Le cycle auquel ce niveau appartient

    // Relation OneToMany avec l'entité Formation
    @OneToMany(mappedBy = "niveau")
    private List<Formation> formations; // Liste des formations associées à ce niveau


    public void setLibelle(String libelle) {
        // Validation et gestion d'exception pour l'attribut libelle
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new NiveauException("Le libellé du niveau ne peut pas être vide.", "EX006");
        }
        this.libelle = libelle;
    }
}
