package com.uasz.enseign.dto.Maquette;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECDTO {
    private Long id;
    private String libelle;
    private String code;
    private int cm;
    private int td;
    private int tp;
    private int tpe;
    private int coefficient;
    private String description;
    private Date dateCreation;
    private UEDTO ue;
    private List<ModuleDTO> module;
}
