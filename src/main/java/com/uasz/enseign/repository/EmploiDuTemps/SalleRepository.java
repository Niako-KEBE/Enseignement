package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.model.Emploie_Du_Temps.Salle;
import com.uasz.enseign.model.Emploie_Du_Temps.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    List<Salle> findByNumero(String numero);

    List<Salle> findByCapacityGreaterThanEqual(int capacity);

    List<Salle> findByBatiment(Batiment batiment);

    @Query("SELECT s FROM Salle s WHERE s.batiment.id = :batimentId")
    List<Salle> findByBatimentId(@Param("batimentId") Long batimentId);
}
