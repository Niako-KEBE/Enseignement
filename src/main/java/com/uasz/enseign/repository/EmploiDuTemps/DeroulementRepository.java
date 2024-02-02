package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.model.Emploie_Du_Temps.Deroulement;
import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeroulementRepository extends JpaRepository<Deroulement, Long> {

    List<Deroulement> findByMatiere(String matiere);

    List<Deroulement> findByDate(Date date);

    List<Deroulement> findByProcessus(String processus);

    List<Deroulement> findBySeance(Seance seance);

    @Query("SELECT d FROM Deroulement d WHERE d.date >= :startDate AND d.date <= :endDate")
    List<Deroulement> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
