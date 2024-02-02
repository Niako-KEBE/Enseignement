package com.uasz.enseign.repository.Repartition;

import com.uasz.enseign.model.Repartition.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepartitionRepository extends JpaRepository<Repartition, Long> {

    List<Repartition> findByClasse(String classe);

    List<Repartition> findByEnseignementId(Long enseignementId);

    List<Repartition> findByEnseignantId(Long enseignantId);

    List<Repartition> findBySemestreAndCreditGreaterThan(int semestre, int credit);

    @Query("SELECT r FROM Repartition r WHERE r.dureeCours >= :dureeCours")
    List<Repartition> findByDureeCoursGreaterThan(@Param("dureeCours") int dureeCours);
}
