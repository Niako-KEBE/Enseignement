package com.uasz.enseign.repository.Utilisateur;

import com.uasz.enseign.model.Maquette.UE;
import com.uasz.enseign.model.Utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur> findByNom(String nom);
//
//    List<Utilisateur> findByPrenom(String prenom);
//
//    List<Utilisateur> findByUes_Id(Long ueId);
}
