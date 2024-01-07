package com.uasz.enseign.dto.Maquette;

import com.uasz.enseign.dto.Utlisateur.UtilisateurDTO;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
@Data
public class UEDTO {

    private Long idUe;
    private String code;
    private String libelle;
    private int credit;
    private int coefficient;
    private String description;
    private Date dateCreation;
    private UtilisateurDTO utilisateur;
    private Collection<ECDTO> ecs;
    private Collection<ModuleDTO> modules;
}