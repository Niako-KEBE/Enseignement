package com.uasz.enseign.dto.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeroulementDTO {
    private Long id;
    private String matiere;
    private Date date;
    private String processus;
    private SeanceDTO seance;
}
