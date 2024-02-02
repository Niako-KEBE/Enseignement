//package com.uasz.enseign.dto.Repartition;
//
//import com.uasz.enseign.entities.EmploiDuTemps.Emploi;
//import com.uasz.enseign.entities.EmploiDuTemps.Seance;
//import com.uasz.enseign.entities.Maquette.Cycle;
//import com.uasz.enseign.entities.Maquette.Filiere;
//import com.uasz.enseign.entities.Maquette.Niveau;
//import com.uasz.enseign.entities.Maquette.Semestre;
//import com.uasz.enseign.entities.Repartition.Enseignant;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class EtudiantDTO {
//    private Long id;
//    private String nom;
//    private String prenom;
//    private String email;
//    private String adresse;
//
//
//    @ManyToOne
//    @JoinColumn(name = "cycle_id")
//    private Cycle cycle;
//
//    @ManyToOne
//    @JoinColumn(name = "filiere_id")
//    private Filiere filiere;
//
//    @ManyToOne
//    @JoinColumn(name = "niveau_id")
//    private Niveau niveau;
//
//    @ManyToOne
//    @JoinColumn(name = "seance_id")
//    private Seance seance;
//
//    @ManyToOne
//    @JoinColumn(name = "enseignant_id")
//    private Enseignant enseignant;
//
//    @ManyToOne
//    @JoinColumn(name = "semestre_id")
//    private Semestre semestre;
//
//    @OneToMany(mappedBy = "etudiant")
//    private List<Emploi> emploiDuTemps;
//
//}
