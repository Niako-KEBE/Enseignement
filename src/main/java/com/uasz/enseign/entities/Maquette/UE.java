package com.uasz.enseign.entities.Maquette;

// Importation des annotations Lombok pour la génération automatique du code

import com.uasz.enseign.entities.Utilisateur.Utilisateur;
import com.uasz.enseign.exceptions.Maquette.UeException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

// Annotation déclarant que cette classe est une entité persistante
@Entity

// Annotations Lombok pour générer automatiquement les méthodes getters, setters, equals, hashCode, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UE {

    // Annotation indiquant que la propriété suivante est une clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUe;

    // Déclaration des propriétés de l'UE
    @Column(nullable = false, length = 20) // Exemple : Non nullable, longueur maximale de 20 caractères
    private String code;

    @Column(nullable = false, length = 100) // Exemple : Non nullable, longueur maximale de 100 caractères
    private String libelle;

    private int credit;
    private int coefficient;

    @Column(length = 255) // Exemple : Longueur maximale de 255 caractères
    private String description;

    // Annotation indiquant le type de la date (DATE uniquement, sans heure)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    // Relation ManyToOne avec l'entité Utilisateur, indiquant que chaque UE est associée à un utilisateur (chef du département)
    @ManyToOne
    @JoinColumn(name = "utilisateur_id") // Nom de la colonne de la clé étrangère
    private Utilisateur utilisateur;

    // Relation OneToMany avec l'entité EC, indiquant qu'une UE peut avoir plusieurs EC (éléments constitutifs)
    @OneToMany(mappedBy = "ue")
    private Collection<EC> ecs;

    // Relation OneToMany avec l'entité Module
    @OneToMany(mappedBy = "ue")
    private Collection<Module> modules;

    // Exemple de vérification et levée d'exception UeException
    public void setCredit(int credit) {
        if (credit < 0) {
            // Lever une exception UeException avec un code d'erreur spécifique
            throw new UeException("La valeur du crédit ne peut pas être négative", "UE_CREDIT_NEGATIF");
        }
        this.credit = credit;
    }

    }
