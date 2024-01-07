package com.uasz.enseign.entities.Repartition;

import com.uasz.enseign.entities.Maquette.Classe;
import com.uasz.enseign.entities.Maquette.Groupe;
import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.exceptions.Repartition.EnseignementException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignement; // Identifiant auto-généré de l'enseignement

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé de l'enseignement

    @Column(length = 255)
    private String objectifs; // Objectifs de l'enseignement

    @Column(length = 255)
    private String description; // Description de l'enseignement

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création de l'enseignement

    // Relation ManyToOne avec l'entité Module
    @ManyToOne
    @JoinColumn(name = "module_id") // Nom de la colonne de la clé étrangère
    private Module module; // Le module associé à cet enseignement

    // Relation ManyToOne avec l'entité Classe
    @ManyToOne
    @JoinColumn(name = "classe_id") // Nom de la colonne de la clé étrangère
    private Classe classe; // La classe associée à cet enseignement

    // Relation ManyToOne avec l'entité Groupe
    @ManyToOne
    @JoinColumn(name = "groupe_id") // Nom de la colonne de la clé étrangère
    private Groupe groupe; // Le groupe associé à cet enseignement


    public void setLibelle(String libelle) {
        // Validation et gestion d'exception pour l'attribut libelle
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new EnseignementException("Libellé de l'enseignement ne peut pas être vide.", "EX009");
        }
        this.libelle = libelle;
    }
}
