package com.uasz.enseign.dto.Utilisateur;

import com.uasz.enseign.dto.Maquette.UEDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String role;
    private List<UEDTO> ues;
}
