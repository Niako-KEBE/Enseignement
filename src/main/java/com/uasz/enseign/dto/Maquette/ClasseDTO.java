package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {
    private Long id;
    private String libelle;
    private int effectif;
    private int nbreGroupe;
    private String description;
    private List<EnseignementDTO> enseignement;
    private SemestreDTO semestre;
    private List<GroupeDTO> groupes;
    private FormationDTO formation;
}
