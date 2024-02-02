package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Cycle; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Niveau; // Importez l'entité plutôt que le DTO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {

    List<Cycle> findByNom(String nom);

    @Query("SELECT c FROM Cycle c JOIN c.niveaux n WHERE n = :niveau")
    List<Cycle> findByNiveau(@Param("niveau") Niveau niveau);

    @Query("SELECT c FROM Cycle c WHERE c.nom = :nom AND SIZE(c.niveaux) > :minNiveauxCount")
    List<Cycle> findByNomAndNiveauxCountGreaterThan(@Param("nom") String nom, @Param("minNiveauxCount") int minNiveauxCount);

}
