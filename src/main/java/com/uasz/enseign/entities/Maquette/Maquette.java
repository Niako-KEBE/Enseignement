package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.MaquetteException;
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
public class Maquette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquette; // Identifiant auto-généré de la maquette

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé de la maquette

    @Column(length = 255)
    private String description; // Description de la maquette

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création de la maquette

    // Relation OneToMany avec l'entité Module
    @OneToMany(mappedBy = "maquette")
    private List<Module> modules; // Liste des modules associés à cette maquette

    // Relation OneToOne avec l'entité Formation
    @OneToOne(fetch = FetchType.LAZY)
    // FetchType.LAZY indique que le chargement de la maquette sera retardé jusqu'à ce qu'elle soit réellement nécessaire, améliorant ainsi les performances.
    @JoinColumn(name = "maquette_id", nullable = false)
    // "maquette_id" est le nom de la colonne de la clé étrangère qui pointe vers la clé primaire de la table Maquette.
    private Formation formation; // La formation associée à cette maquette

    // Ajout de la validation dans la méthode saveCycle
    public void saveMaquette() {
        // Vérification de la propriété libelle
        if (libelle == null || libelle.trim().isEmpty()) {
            // Génération de l'exception avec un message explicatif et un code d'erreur
            throw new MaquetteException("Le libellé de la maquette ne peut pas être vide.", "EX002");
        }
    }
}