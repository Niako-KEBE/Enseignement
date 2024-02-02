package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import com.uasz.enseign.model.Emploie_Du_Temps.Emploi;
import com.uasz.enseign.model.Emploie_Du_Temps.Deroulement;
import com.uasz.enseign.model.Repartition.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

    List<Seance> findByTitre(String titre);

    List<Seance> findByDateDebutAfter(Date dateDebut);

    List<Seance> findByDateFinBefore(Date dateFin);

    List<Seance> findByEmploi(Emploi emploi);

    List<Seance> findByDeroulement(Deroulement deroulement);

    List<Seance> findByRepartition(Repartition repartition);

    @Query("SELECT s FROM Seance s WHERE s.dateDebut >= :startDate AND s.dateFin <= :endDate")
    List<Seance> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
