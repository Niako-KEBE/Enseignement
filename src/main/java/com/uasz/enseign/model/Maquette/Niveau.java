package com.uasz.enseign.model.Maquette;

import com.uasz.enseign.model.Maquette.Cycle;
import com.uasz.enseign.model.Maquette.Formation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "niveau")
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "cycle_id")
    private Cycle cycle;

    @OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL)
    private List<Formation> formations;
}
