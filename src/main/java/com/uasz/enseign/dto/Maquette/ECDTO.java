package com.uasz.enseign.dto.Maquette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ECDTO {

    private Long idEc;
    private String code;
    private String libelle;
    private String cm;
    private String td;
    private String tp;
    private String cumulCMTDTP;
    private String tpe;
    private int volumeHT;
    private int coefficient;
    private String description;
    private Date dateCreation;
    private UEDTO ue; // Utilisation du DTO correspondant à UE
    private List<ModuleDTO> modules;

}
