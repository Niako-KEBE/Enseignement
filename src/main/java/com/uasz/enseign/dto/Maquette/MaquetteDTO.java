package com.uasz.enseign.dto.Maquette;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaquetteDTO {
    private Long id;
    private String ue;
    private int credit;
    private int coefUe;
    private String intitule;
    private int cm;
    private int td;
    private int tp;
    private int cumule;
    private int tpe;
    private int vh;
    private int coef;
    private FormationDTO formation;
    private List<ModuleDTO> modules;
}

