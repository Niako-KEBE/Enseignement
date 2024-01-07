package com.uasz.enseign.entities.Repartition;

import com.uasz.enseign.exceptions.Repartition.EnseignantException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
//Ces annotations génèrent automatiquement des constructeurs avec tous les arguments
@Data
@AllArgsConstructor @NoArgsConstructor
//Spécifie que l'héritage sera géré avec une seule table.
// Les sous-classes partageront la même table avec cette stratégie.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

//Indique le nom de la colonne discriminante qui sera utilisée pour distinguer les différentes
// sous-classes dans le cas d'une stratégie d'héritage de table unique.
@DiscriminatorColumn(name = "type" , length = 3)

public abstract class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant; // Identifiant auto-généré de l'enseignant

    @Column(nullable = false, length = 50)
    private String nom; // Nom de l'enseignant

    @Column(nullable = false, length = 50)
    private String prenom; // Prénom de l'enseignant

    @Column(nullable = false, length = 100)
    private String email; // Adresse e-mail de l'enseignant

    @Temporal(TemporalType.DATE)
    private Date datecreation; // Date de naissance de l'enseignant

    @Column(nullable = false)
    private String adresse; // Adresse de l'enseignant

    @Column(nullable = false, length = 15)
    private String telephone; // Numéro de téléphone de l'enseignant

    @Column(nullable = false, length = 20)
    private  String grade ; // Grade de l'enseignant

    public void setEmail(String email) {
        // Validation et gestion d'exception pour l'attribut email
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$")) {
            throw new EnseignantException("Adresse e-mail invalide.", "EX008");
        }
        this.email = email;
    }
}
