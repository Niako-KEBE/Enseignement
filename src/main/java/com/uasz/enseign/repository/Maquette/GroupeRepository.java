package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Groupe;
import com.uasz.enseign.entities.Repartition.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    // Méthode pour récupérer les enseignements associés à un groupe
    @Query("SELECT e FROM Enseignement e WHERE e.groupe = ?1")
    List<Enseignement> findEnseignementsByGroupe(Groupe groupe);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
