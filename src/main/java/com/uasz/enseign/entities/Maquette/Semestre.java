package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.exceptions.Maquette.SemestreException;
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
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemestre; // Identifiant auto-généré du semestre

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé du semestre

    @Column(length = 255)
    private String description; // Description du semestre

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création du semestre

    // Relation OneToMany avec l'entité Module
    @OneToMany(mappedBy = "semestre")
    private List<Module> modules; // Liste des modules associés à ce semestre

    // Relation OneToMany avec l'entité Classe
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes; // Liste des classes associées à ce semestre

    //méthodes et validations nécessitant

    public void setLibelle(String libelle) {
        // Validation et gestion d'exception pour l'attribut libelle
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new SemestreException("Le libellé du semestre ne peut pas être vide.", "EX007");
        }
        this.libelle = libelle;
    }

    // ... (autres méthodes et validations nécessitant la gestion de SemestreException)

}
