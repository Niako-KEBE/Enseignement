package com.uasz.enseign.entities.Maquette;
import com.uasz.enseign.exceptions.Maquette.EcException;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
// Déclaration de la classe EC comme entité persistante avec annotations Lombok pour les méthodes equals, hashCode, toString, getters et setters.

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class EC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Déclaration de l'ID avec génération automatique basée sur l'IDENTITY.
    private Long idEc ;

    // Champ pour le code de l'EC.
    @Column(nullable = false, length = 20)
    private String code ;

    //Champ pour le libellé de l'EC.
    @Column(nullable = false, length = 100)
    private String libelle;

    //Champ pour le nombre d'heures de cours magistraux.
    @Column(name = "nb_heures_cm")
    private String cm ;

    //Champ pour le nombre d'heures de travaux dirigés.
    @Column(name = "nb_heures_td")
    private  String td;

    //Champ pour le nombre d'heures de travaux pratiques.
    @Column(name = "nb_heures_tp")
    private  String tp ;

    @Column(name = "cumul_cm_td_tp")
    private String cumulCMTDTP;

    //Champ pour le nombre d'heures de travaux pratiques encadrés.
    @Column(name = "nb_heures_tpe")
    private String tpe ;

    @Column(name = "volume_ht")
    private int volumeHT;

    // Champ pour le coefficient de l'EC.
    private int coefficient ;

    // Champ pour une description de l'EC.
    @Column(length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    // Relation many-to-one indiquant qu'une EC appartient à une UE et quon UE peux avoir plusieur EC.
    @ManyToOne
    @JoinColumn(name = "ue_id") // Nom de la colonne de la clé étrangère
    private UE ue;

    // Relation OneToMany avec l'entité Module
    @OneToMany(mappedBy = "ec")
    private List<Module> modules;

    // Exemple de vérification et levée d'exception UeException
    public void validateEC() {
        if (code == null || code.trim().isEmpty()) {
            throw new EcException("Le code de l'EC ne peut pas être nul ou vide.", "EC_CODE_NON_VALIDE");
        }

        if (libelle == null || libelle.trim().isEmpty()) {
            throw new EcException("Le libellé de l'EC ne peut pas être nul ou vide.", "EC_LIBELLE_NON_VALIDE");
        }
    }
}