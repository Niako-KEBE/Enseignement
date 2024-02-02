package com.uasz.enseign.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Table(name = "module")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    @ManyToOne
    private UE ue;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private Semestre semestre;
//    @ManyToMany (mappedBy = "module")
//    private List<Enseignement>enseignements;
    @ManyToOne
    private Maquette maquette;
    // Dans la classe Module
    @OneToMany(mappedBy = "module") // Assurez-vous que "module" correspond au nom du champ dans Enseignement
    private List<Enseignement> enseignements;

}
