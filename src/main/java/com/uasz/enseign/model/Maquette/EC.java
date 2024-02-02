    package com.uasz.enseign.model.Maquette;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
    @Table(name = "ec")

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EC {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String libelle;
        private int cm;
        private int td;
        private int tp;
        private int tpe;
        @Column(name = "code") // Assurez-vous de spécifier le bon nom de colonne
        private String code;
        private int coefficient;
        private String description;
        private Date dateCreation;
        
        @ManyToOne
        private UE ue;

        @ManyToOne
        @JoinColumn(name = "semestre_id") // Assurez-vous de spécifier le bon nom de colonne
        private Semestre semestre;
        
        @OneToMany(mappedBy = "ec")
        private List<Module> module;

    }
