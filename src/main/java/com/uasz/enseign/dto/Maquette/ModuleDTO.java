package com.uasz.enseign.dto.Maquette;

import com.uasz.enseign.dto.Repartition.EnseignementDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {

    private Long idModule;
    private String libelle;
    private String cours;
    private int duree;
    private String objectifs;
    private String description;
    private Date dateCreation;
    private ECDTO ec; // Utilisation du DTO correspondant à EC
    private UEDTO ue; // Utilisation du DTO correspondant à UE
    private MaquetteDTO maquette; // Utilisation du DTO correspondant à Maquette
    private SemestreDTO semestre; // Utilisation du DTO correspondant à Semestre
    private List<EnseignementDTO> enseignements;

    // Aucun besoin d'ajouter explicitement des méthodes getter et setter grâce à Lombok
}
