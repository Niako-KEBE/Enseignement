package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.entities.EmploiDuTemps.Emploi;
import com.uasz.enseign.entities.EmploiDuTemps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiRepository extends JpaRepository<Emploi, Long> {

    // Autres méthodes CRUD de base

    // Méthode personnalisée pour rechercher des emplois du temps par séance
    @Query("SELECT e FROM Emploi e JOIN e.seances s WHERE s = :seance")
    List<Emploi> findBySeance(@Param("seance") Seance seance);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
