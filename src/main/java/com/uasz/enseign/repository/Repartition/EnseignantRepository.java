package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.entities.Repartition.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    // Ajoutez des méthodes personnalisées au besoin
}
