package com.uasz.enseign.repository.EmploiDuTemps;

import com.uasz.enseign.model.Emploie_Du_Temps.Batiment;
import com.uasz.enseign.model.Emploie_Du_Temps.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {

    List<Batiment> findByNom(String nom);

    List<Batiment> findBySallesContaining(Salle salle);

}
