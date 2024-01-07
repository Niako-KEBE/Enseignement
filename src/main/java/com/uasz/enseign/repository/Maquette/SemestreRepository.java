package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.Semestre;
import com.uasz.enseign.entities.Maquette.Classe;
import com.uasz.enseign.entities.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    // Méthode personnalisée pour rechercher les classes associées à un semestre donné
    @Query("SELECT c FROM Classe c WHERE c.semestre = ?1")
    List<Classe> findClassesBySemestre(Semestre semestre);

    // Méthode personnalisée pour rechercher les modules associés à un semestre donné
    @Query("SELECT m FROM Module m WHERE m.semestre = ?1")
    List<Module> findModulesBySemestre(Semestre semestre);

    // Ajoutez d'autres méthodes personnalisées au besoin
}
