package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.FormationException;
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
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation; // Identifiant auto-généré de la formation

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé de la formation

    @Column(length = 255)
    private String description; // Description de la formation

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création de la formation

    // Relation OneToOne avec l'entité Niveau
    @ManyToOne
    @JoinColumn(name = "niveau_id") // Nom de la colonne de la clé étrangère
    private Niveau niveau; // Le niveau auquel cette formation est associée

    // Relation ManyToOne avec l'entité Filiere
    @ManyToOne
    @JoinColumn(name = "filiere_id") // Nom de la colonne de la clé étrangère
    private Filiere filiere; // La filière à laquelle cette formation est associée

    // Relation OneToOne avec l'entité Maquette
    @OneToOne(mappedBy = "formation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // cascade = CascadeType.ALL spécifie que toutes les opérations (insertion, mise à jour, suppression) sur la maquette doivent être propagées à la formation.
    private Maquette maquette; // La maquette associée à cette formation


    // Relation OneToMany avec l'entité Classe
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classe> classes; // Les classes associées à cette formation

    // Ajout de la validation dans la méthode saveFormation
    public void saveFormation() {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new FormationException("Libellé de la formation ne peut pas être vide.", "LIBELLE_VIDE");
        }

        if (description != null && description.length() > 255) {
            throw new FormationException("La description de la formation dépasse la longueur maximale autorisée.", "DESCRIPTION_LONGUE");
        }

        if (niveau == null) {
            throw new FormationException("La formation doit être associée à un niveau.", "NIVEAU_ABSENT");
        }

        // Ajoutez d'autres validations au besoin...
    }

}
