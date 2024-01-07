package com.uasz.enseign.dto.Repartition;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import com.uasz.enseign.dto.Maquette.GroupeDTO;
import com.uasz.enseign.dto.Maquette.ModuleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignementDTO {

    private Long idEnseignement;
    private String libelle;
    private String objectifs;
    private String description;
    private Date dateCreation;
    private ModuleDTO module; // Utilisation du DTO correspondant à Module
    private ClasseDTO classe; // Utilisation du DTO correspondant à Classe
    private GroupeDTO groupe; // Utilisation du DTO correspondant à Groupe

}
