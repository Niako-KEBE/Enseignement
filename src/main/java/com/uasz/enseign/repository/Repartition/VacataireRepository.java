package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.entities.Repartition.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacataireRepository extends JpaRepository<Vacataire, Long> {

    // Recherche un vacataire par spécialité
    Optional<Vacataire> findBySpecialite(String specialite);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
