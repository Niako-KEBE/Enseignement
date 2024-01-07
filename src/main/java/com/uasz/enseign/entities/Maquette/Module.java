package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.exceptions.Maquette.ModuleException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule; // Identifiant auto-généré de la table Module

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé du module

    private String cours; // Informations sur le cours

    private int duree; // Durée du module en heures

    private String objectifs; // Objectifs du module

    @Column(length = 255)
    private String description; // Description du module

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création du module

    // Relation ManyToOne avec l'entité EC
    @ManyToOne
    @JoinColumn(name = "ec_id") // Nom de la colonne de la clé étrangère
    private EC ec; // Lien vers l'EC associé à ce modul

    // Relation ManyToOne avec l'entité UE
    @ManyToOne
    @JoinColumn(name = "ue_id") // Nom de la colonne de la clé étrangère
    private UE ue; // Lien vers l'UE associée à ce module

    // Relation ManyToOne avec l'entité Maquette
    @ManyToOne
    @JoinColumn(name = "maquette_id") // Nom de la colonne de la clé étrangère
    private Maquette maquette; // Lien vers la maquette associée à ce module

    // Relation ManyToOne avec l'entité Semestre
    @ManyToOne
    @JoinColumn(name = "semestre_id") // Nom de la colonne de la clé étrangère
    private Semestre semestre; // Lien vers le semestre associé à ce module

    // Relation OneToMany avec l'entité Enseignement
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Enseignement> enseignements; // Les enseignements associés à ce module



    // Ajoutez des méthodes ou des validations nécessitant la gestion de ModuleException
    public void setCours(String cours) {
        // Validation et gestion d'exception pour l'attribut cours
        if (cours == null || cours.trim().isEmpty()) {
            throw new ModuleException("Le cours ne peut pas être vide.", "EX003");
        }
        this.cours = cours;
    }

    public void setDuree(int duree) {
        // Validation et gestion d'exception pour l'attribut duree
        if (duree <= 0) {
            throw new ModuleException("La durée doit être supérieure à zéro.", "EX004");
        }
        this.duree = duree;
    }

    public void setObjectifs(String objectifs) {
        // Validation et gestion d'exception pour l'attribut objectifs
        if (objectifs == null || objectifs.trim().isEmpty()) {
            throw new ModuleException("Les objectifs ne peuvent pas être vides.", "EX005");
        }
        this.objectifs = objectifs;
    }


}
