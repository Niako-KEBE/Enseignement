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
    private Long id;
    private String titre;
    private Date dateDebut;
    private Date dateFin;
    private EmploiDTO emploi;
    private DeroulementDTO deroulement;
    private RepartitionDTO repartition;
}
