package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    // Méthode personnalisée pour rechercher des formations par libellé
    List<Formation> findByLibelleContainingIgnoreCase(String libelle);

    // Méthode personnalisée pour rechercher des formations par filière
    List<Formation> findByFiliereId(Long filiereId);

    // Méthode personnalisée pour récupérer les formations ayant une description non vide
    @Query("SELECT f FROM Formation f WHERE f.description IS NOT NULL AND f.description <> ''")
    List<Formation> findFormationsWithDescription();

    // Méthode personnalisée pour rechercher des formations par classe
    @Query("SELECT f FROM Formation f JOIN f.classes c WHERE c.idClasse = ?1")
    List<Formation> findByClasseId(Long classeId);

    // Méthode personnalisée pour rechercher des formations par maquette
    @Query("SELECT f FROM Formation f WHERE f.maquette.idMaquette = ?1")
    List<Formation> findByMaquetteId(Long maquetteId);

    // Vous pouvez ajouter d'autres méthodes personnalisées au besoin

}
