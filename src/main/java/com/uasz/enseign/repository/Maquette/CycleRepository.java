package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Cycle;
import com.uasz.enseign.entities.Maquette.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {

    // Méthode personnalisée pour rechercher les niveaux associés à un cycle
    List<Niveau> findNiveauxByCycle(Cycle cycle);

    // Vous pouvez ajouter d'autres méthodes personnalisées au besoin

}
