package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.entities.Repartition.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    // Méthode pour récupérer les enseignements associés à un module
    @Query("SELECT e FROM Enseignement e WHERE e.module = ?1")
    List<Enseignement> findEnseignementsByModule(Module module);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
