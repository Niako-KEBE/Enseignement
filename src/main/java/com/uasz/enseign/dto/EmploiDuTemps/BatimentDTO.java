package com.uasz.enseign.dto.EmploiDuTemps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatimentDTO {

    private Long id;
    private String libelle;
    private String code;
    private String position;
    private String description;
    private Date dateCreation;
    private List<SalleDTO> salles;

}
