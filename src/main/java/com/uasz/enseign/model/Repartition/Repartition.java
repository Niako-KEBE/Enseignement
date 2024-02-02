package com.uasz.enseign.model.Repartition;

import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import com.uasz.enseign.model.Maquette.Enseignement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classe;
    private int effectif;
    private  int semestre;
    @ManyToOne
    private Enseignement enseignement;
    private int credit;
    private int dureeCours;
    @ManyToOne
    private Enseignant enseignant;
    private int cm;
    private String ResponsableTD;
    private String ResponsableTP;
    private int travauxDirige;
    private int travauxPratique;
    @OneToMany(mappedBy = "repartition")
    private List<Seance> seances;
}
