package com.uasz.enseign.dto.Maquette;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeDTO {
    private Long id;
    private String libelle;
    private int effectif;
    private String description;
    private List<EnseignementDTO> enseignement;
    private ClasseDTO classe;

}

