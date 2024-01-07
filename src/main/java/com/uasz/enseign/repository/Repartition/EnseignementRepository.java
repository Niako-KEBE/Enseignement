package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.entities.Repartition.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {
    // Ajoutez des méthodes personnalisées au besoin
}
