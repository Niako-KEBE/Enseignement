package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.model.Emploie_Du_Temps.Emploi;
import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmploiRepository extends JpaRepository<Emploi, Long> {

    List<Emploi> findByDuree(int duree);

    List<Emploi> findByDebutAfter(Date debut);

    List<Emploi> findByFinBefore(Date fin);

    @Query("SELECT e FROM Emploi e JOIN e.seances s WHERE s = :seance")
    List<Emploi> findBySeance(@Param("seance") Seance seance);

}
