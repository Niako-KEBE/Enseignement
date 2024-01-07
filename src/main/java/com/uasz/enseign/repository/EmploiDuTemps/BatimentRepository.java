package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.entities.EmploiDuTemps.Batiment;
import com.uasz.enseign.entities.EmploiDuTemps.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {

    // Recherche les salles associées à un bâtiment en utilisant @Query
    @Query("SELECT s FROM Salle s WHERE s.batiment = :batiment")
    List<Salle> findSallesByBatiment(Batiment batiment);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
