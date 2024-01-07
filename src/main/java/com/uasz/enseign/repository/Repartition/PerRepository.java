package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.entities.Repartition.PER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Importe la classe Optional de Java,
// qui est utilisée pour exprimer explicitement la possibilité d'absence de résultats.
import java.util.Optional;

//Annotation indiquant que cette interface est un repository Spring.
@Repository
public interface PerRepository extends JpaRepository<PER, Long> {

    Optional<PER> findByMatricule(String matricule);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
