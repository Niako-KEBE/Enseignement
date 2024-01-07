package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.CycleException;
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
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCycle; // Identifiant auto-généré du cycle

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé du cycle

    @Column(length = 255)
    private String description; // Description du cycle

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création du cycle

    // Relation OneToMany avec l'entité Niveau
    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux; // Liste des niveaux associés à ce cycle

    // Ajout de la validation dans la méthode saveCycle
    public void validateCycle() {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new CycleException("Libellé du cycle ne peut pas être vide.", "LIBELLE_VIDE");
        }

        // Ajoutez d'autres validations au besoin...
    }

}
