package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NiveauDTO {

    private Long idNiveau;
    private String libelle;
    private String description;
    private Date dateCreation;
    private CycleDTO cycle; // Utilisation du DTO correspondant à Cycle
    private List<FormationDTO> formations;

}
