package com.uasz.enseign.dto.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDTO {
    private Long id;
    private int duree;
    private Date debut;
    private Date fin;
    private List<SeanceDTO> seances;
}
