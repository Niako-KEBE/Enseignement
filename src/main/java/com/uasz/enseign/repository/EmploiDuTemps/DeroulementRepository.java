package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.entities.EmploiDuTemps.Deroulement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeroulementRepository extends JpaRepository<Deroulement, Long> {

    // Ajoutez d'autres méthodes personnalisées au besoin

}
