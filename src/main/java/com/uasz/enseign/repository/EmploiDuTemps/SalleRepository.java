package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.entities.EmploiDuTemps.Salle;
import com.uasz.enseign.entities.EmploiDuTemps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    // Recherche des salles associées à une séance
    List<Salle> findBySeancesContains(Seance seance);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
