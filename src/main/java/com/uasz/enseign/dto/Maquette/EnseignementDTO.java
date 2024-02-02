package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnseignementDTO {
    private Long id;
    private String libelle;
    private String description;
    private ClasseDTO classe;
    private GroupeDTO groupe;
    private List<ModuleDTO> modules;
}
