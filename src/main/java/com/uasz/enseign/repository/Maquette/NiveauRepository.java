package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Niveau;
import com.uasz.enseign.entities.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

    // Méthode personnalisée pour rechercher des formations associées à un niveau
    @Query("SELECT f FROM Formation f WHERE f.niveau = :niveau")
    List<Formation> findFormationsByNiveau(Niveau niveau);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
