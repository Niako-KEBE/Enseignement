package com.uasz.enseign.services.Utilisateur;

import com.uasz.enseign.dto.Utilisateur.UtilisateurDTO;

import javax.management.relation.Relation;
import java.util.List;

public interface UtilisateurService {

    List<UtilisateurDTO> getAllUtilisateurs();

    UtilisateurDTO getUtilisateurById(Long id);

    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO);

    void deleteUtilisateur(Long id);
//
//    Relation findByEmail(String name);
}
