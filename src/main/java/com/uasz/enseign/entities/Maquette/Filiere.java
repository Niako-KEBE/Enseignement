package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.FiliereException;
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
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere; // Identifiant auto-généré de la filière

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé de la filière

    @Column(length = 255)
    private String description; // Description de la filière

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création de la filière

    // Relation OneToMany avec l'entité Formation
    @OneToMany(mappedBy = "filiere")
    private List<Formation> formations; // Liste des formations associées à cette filière

    // Ajout de la validation dans la méthode saveFiliere
    public void saveFiliere() {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new FiliereException("Libellé de la filière ne peut pas être vide.", "LIBELLE_VIDE");
        }

        // Ajoutez d'autres validations au besoin...
    }
}
