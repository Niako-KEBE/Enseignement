package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.exceptions.Maquette.GroupeException;
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
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe; // Identifiant auto-généré du groupe

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé du groupe

    @Column(nullable = false)
    private int numero; // Numéro du groupe

    @Column(nullable = false)
    private int effectif; // Effectif du groupe

    @Column(length = 255)
    private String description; // Description du groupe

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création du groupe

    // Relation ManyToOne avec l'entité Classe
    @ManyToOne
    @JoinColumn(name = "classe_id") // Nom de la colonne de la clé étrangère
    private Classe classe; // La classe à laquelle ce groupe appartient

    // Relation OneToMany avec l'entité Enseignement
    @OneToMany(mappedBy = "groupe")
    private Collection<Enseignement> enseignements; // Les enseignements associés à ce groupe

    // Exemple d'utilisation de GroupeException
    public void saveGroupe() {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new GroupeException("Libellé du groupe ne peut pas être vide.", "LIBELLE_VIDE");
        }

        if (numero <= 0) {
            throw new GroupeException("Le numéro du groupe doit être un entier positif.", "NUMERO_INVALIDE");
        }

        if (effectif <= 0) {
            throw new GroupeException("L'effectif du groupe doit être un entier positif.", "EFFECTIF_INVALIDE");
        }

        if (classe == null) {
            throw new GroupeException("Le groupe doit être associé à une classe.", "CLASSE_ABSENTE");
        }

        // Ajoutez d'autres validations au besoin...
    }

}