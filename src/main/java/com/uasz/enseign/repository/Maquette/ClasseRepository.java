package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Classe;
import com.uasz.enseign.entities.Maquette.Groupe;
import com.uasz.enseign.entities.Repartition.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    // Méthode pour rechercher une classe par son libellé
    Optional<Classe> findByLibelle(String libelle);

    // Méthode pour rechercher les classes associées à un semestre donné
    List<Classe> findBySemestre_Id(Long semestreId);

    // Méthode pour rechercher les classes ayant un certain effectif
    List<Classe> findByEffectif(int effectif);

    // Méthode pour rechercher les classes ayant un certain nombre de groupes
    List<Classe> findByNbreGroupe(int nbreGroupe);

    // Méthode personnalisée pour rechercher les classes par description en utilisant la convention de nommage de Spring Data JPA
    List<Classe> findByDescriptionContainingIgnoreCase(String description);

    // Méthode personnalisée pour rechercher les enseignements associés à une classe donnée
    @Query("SELECT e FROM Enseignement e WHERE e.classe = ?1")
    List<Enseignement> findEnseignementsByClasse(Classe classe);

    // Méthode personnalisée pour rechercher les groupes associés à une classe donnée
    @Query("SELECT g FROM Groupe g WHERE g.classe = ?1")
    List<Groupe> findGroupesByClasse(Classe classe);

    // Autres méthodes personnalisées selon vos besoins

}
