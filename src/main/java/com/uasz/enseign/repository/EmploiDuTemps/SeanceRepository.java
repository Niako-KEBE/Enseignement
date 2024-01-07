package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.entities.EmploiDuTemps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

    // Recherche des séances associées à un jour spécifique
    List<Seance> findByJour(String jour);

    // Recherche des séances associées à une répartition
    List<Seance> findByRepartitionId(Long repartitionId);

    // Recherche des séances associées à un emploi du temps
    List<Seance> findByEmploiId(Long emploiId);

    // Recherche des séances associées à un déroulement
    List<Seance> findByDeroulementId(Long deroulementId);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
