package com.uasz.enseign.repository.Utilisateur;

import com.uasz.enseign.entities.Utilisateur.Utilisateur;
import com.uasz.enseign.entities.Maquette.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Méthode personnalisée pour rechercher des UE associées à un utilisateur
    @Query("SELECT u.ues FROM Utilisateur u WHERE u.idUser = :userId")
    Collection<UE> findUesByUtilisateurId(Long userId);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
