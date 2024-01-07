package com.uasz.enseign.dto.Utlisateur;

import com.uasz.enseign.dto.Maquette.UEDTO;
import lombok.Data;

import java.util.Collection;


@Data
public class UtilisateurDTO {

        private Long idUser;
        private String nom;
        private String prenom;
        private String role;
        private Collection<UEDTO> ues;
}
