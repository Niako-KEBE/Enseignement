package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemestreDTO {

    private Long idSemestre;
    private String libelle;
    private String description;
    private Date dateCreation;
    private List<ModuleDTO> modules;
    private List<ClasseDTO> classes;

}

