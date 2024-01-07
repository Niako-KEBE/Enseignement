package com.uasz.enseign.dto.EmploiDuTemps;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {

    private Long idSeance;
    private String jour;
    private int duree;
    private String debut;
    private String fin;
    private int numero;
    private Date dateCreation;
    private RepartitionDTO repartition;
    private EmploiDTO emploi;
    private DeroulementDTO deroulement;
    private SalleDTO salle;

}
