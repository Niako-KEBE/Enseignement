package com.uasz.enseign.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Table(name = "semestre")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private String description;
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;
    @OneToMany(mappedBy = "semestre")
    private List<Module> modules;
}
