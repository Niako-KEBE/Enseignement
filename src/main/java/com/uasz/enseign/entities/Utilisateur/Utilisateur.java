package com.uasz.enseign.entities.Utilisateur;


// Importation des annotations nécessaires pour Java Persistence API (JPA)

import com.uasz.enseign.entities.Maquette.UE;
import com.uasz.enseign.exceptions.Utilisateur.UtilisateurException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

// Annotation déclarant que cette classe est une entité persistante
@Entity

// Annotations Lombok pour générer automatiquement les méthodes getters, setters, equals, hashCode, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    // Annotation indiquant que la propriété suivante est une clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "nom", nullable = false, length = 50) // Exemple : Non nullable, longueur maximale de 50 caractères
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100) // Exemple : Non nullable, longueur maximale de 100 caractères
    private String prenom;

    @Column(name = "role", nullable = false, length = 200) // Exemple : Non nullable, longueur maximale de 200 caractères
    private String role;
    // Relation OneToMany avec l'entité UE, indiquant qu'un utilisateur peut être associé à plusieurs UE
    @OneToMany(mappedBy = "utilisateur")
    private Collection<UE> ues;

    // Example method demonstrating the use of UtilisateurException
    public void validateUtilisateur() {
        // Replace the condition with your actual validation logic
        if (role == null || role.trim().isEmpty()) {
            throw new UtilisateurException("Le rôle de l'utilisateur ne peut pas être vide.", "USR001");
        }

        // Add more validations as needed...
    }
}