package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Maquette;
import com.uasz.enseign.entities.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

    // Méthode personnalisée pour rechercher les maquettes associées à un module
    @Query("SELECT m FROM Maquette m JOIN m.modules mod WHERE mod = ?1")
    List<Maquette> findByModule(Module module);

    // Ajoutez d'autres méthodes personnalisées au besoin

}
