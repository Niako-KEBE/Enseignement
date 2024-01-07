package com.uasz.enseign.entities.Maquette;

import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.exceptions.Maquette.ClasseException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse; // Identifiant auto-généré de la classe

    @Column(nullable = false, length = 100)
    private String libelle; // Libellé de la classe

    private int effectif; // Effectif de la classe

    private int nbreGroupe; // Nombre de groupes dans la classe

    @Column(length = 255)
    private String description; // Description de la classe

    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Date de création de la classe

    // Relation ManyToOne avec l'entité Semestre
    @ManyToOne
    @JoinColumn(name = "semestre_id") // Nom de la colonne de la clé étrangère
    private Semestre semestre; // Le semestre auquel cette classe est associée

    // Relation ManyToOne avec l'entité Formation
    @ManyToOne
    @JoinColumn(name = "formation_id") // Nom de la colonne de la clé étrangère
    private Formation formation; // La formation à laquelle cette classe est associée

    // Relation OneToMany avec l'entité Groupe
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Groupe> groupes; // Les groupes associés à cette classe

    // Relation OneToMany avec l'entité Enseignement
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Enseignement> enseignements; // Les enseignements associés à cette classe

    public void validateClasse() {
        if (libelle == null || libelle.trim().isEmpty()) {
            throw new ClasseException("Libellé de la classe ne peut pas être vide.", "LIBELLE_VIDE");
        }
    }

}
