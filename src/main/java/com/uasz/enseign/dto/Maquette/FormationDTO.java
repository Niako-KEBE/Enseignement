package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationDTO {
    private Long id;
    private String nom;
    private FiliereDTO filiere;
    private MaquetteDTO maquette;
    private List<ClasseDTO> classes;
    private NiveauDTO niveau;
}
