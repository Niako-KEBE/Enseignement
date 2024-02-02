package com.uasz.enseign.dto.Repartition;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import com.uasz.enseign.dto.Maquette.EnseignementDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartitionDTO {
    private Long id;
    private String classe;
    private int effectif;
    private int semestre;
    private EnseignementDTO enseignement;
    private int credit;
    private int dureeCours;
    private EnseignantDTO enseignant;
    private int cm;
    private String responsableTD;
    private String responsableTP;
    private int travauxDirige;
    private int travauxPratique;
    private List<SeanceDTO> seances;
}


