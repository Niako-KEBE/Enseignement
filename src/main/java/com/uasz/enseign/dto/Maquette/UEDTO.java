package com.uasz.enseign.dto.Maquette;

import com.uasz.enseign.dto.Utilisateur.UtilisateurDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UEDTO {
    private Long id;
    private String libelle;
    private String code;
    private String description;
    private List<ECDTO> ecs;
    private List<ModuleDTO> modules;
    private Date createdAt;
    private UtilisateurDTO utilisateur;
    private int credit;
    private int coefficient;
}
