package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Formation; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Filiere;
import com.uasz.enseign.model.Maquette.Maquette;
import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.model.Maquette.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    List<Formation> findByNom(String nom);

    List<Formation> findByFiliere(Filiere filiere);

    List<Formation> findByMaquette(Maquette maquette);

    @Query("SELECT f FROM Formation f JOIN f.classes c WHERE c = :classe")
    List<Formation> findByClasse(@Param("classe") Classe classe);

    List<Formation> findByNiveau(Niveau niveau);
}
