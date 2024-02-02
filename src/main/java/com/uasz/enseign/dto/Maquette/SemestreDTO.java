package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemestreDTO {
    private Long id;
    private String libelle;
    private String description;
    private List<ClasseDTO> classes;
    private List<ModuleDTO> modules;
}

