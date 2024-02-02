package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDTO {
    private Long id;
    private String nom;
    private UEDTO ue;
    private ECDTO ec;
    private SemestreDTO semestre;
    private List<EnseignementDTO> enseignements;
    private MaquetteDTO maquette;
}
