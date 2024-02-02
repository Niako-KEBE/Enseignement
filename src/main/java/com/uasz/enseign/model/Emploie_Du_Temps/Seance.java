package com.uasz.enseign.model.Emploie_Du_Temps;

import com.uasz.enseign.model.Repartition.Repartition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    private Emploi emploi;
    @OneToOne(mappedBy = "seance")
    private Deroulement deroulement ;
    @ManyToOne
    private Repartition repartition;
}
