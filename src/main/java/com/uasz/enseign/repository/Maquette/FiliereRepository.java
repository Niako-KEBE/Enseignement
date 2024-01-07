package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Filiere;
import com.uasz.enseign.entities.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

    // Méthode personnalisée pour récupérer toutes les formations associées à une filière
    @Query("SELECT f.formations FROM Filiere f WHERE f.idFiliere = :filiereId")
    List<Formation> findFormationsByFiliereId(Long filiereId);

    // Vous pouvez ajouter d'autres méthodes personnalisées au besoin

}
