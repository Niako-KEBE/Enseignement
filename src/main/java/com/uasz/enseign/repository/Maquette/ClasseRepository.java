package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Classe; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Semestre;
import com.uasz.enseign.model.Maquette.Formation;
import com.uasz.enseign.model.Maquette.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    List<Classe> findByLibelle(String libelle);

    List<Classe> findByEffectif(int effectif);

    List<Classe> findByFormation(Formation formation);

    @Query("SELECT c FROM Classe c WHERE c.libelle = :libelle AND c.formation = :formation")
    List<Classe> findByLibelleAndFormation(@Param("libelle") String libelle, @Param("formation") Formation formation);

    List<Classe> findByNbreGroupe(int nbreGroupe);

    List<Classe> findBySemestre(Semestre semestre);

    @Query("SELECT c FROM Classe c JOIN c.enseignement e WHERE e = :enseignement")
    List<Classe> findByEnseignement(@Param("enseignement") Enseignement enseignement);
}
