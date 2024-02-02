package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Filiere; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

    List<Filiere> findByNom(String nom);

    @Query("SELECT f FROM Filiere f JOIN f.formations fo WHERE fo = :formation")
    List<Filiere> findByFormation(@Param("formation") Formation formation);
}
