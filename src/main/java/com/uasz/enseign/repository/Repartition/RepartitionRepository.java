package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.entities.Repartition.Repartition;
import com.uasz.enseign.entities.EmploiDuTemps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepartitionRepository extends JpaRepository<Repartition, Long> {

    // ... (autres méthodes personnalisées)

    // Recherche des séances associées à une répartition par son identifiant
    @Query("SELECT s FROM Seance s WHERE s.repartition.idRepartition = :repartitionId")
    List<Seance> findSeancesByRepartitionId(Long repartitionId);
}
