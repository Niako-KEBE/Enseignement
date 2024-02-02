package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Groupe; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Enseignement;
import com.uasz.enseign.model.Maquette.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    List<Groupe> findByLibelle(String libelle);

    List<Groupe> findByEffectifGreaterThan(int effectif);

    List<Groupe> findByClasse(Classe classe);

    @Query("SELECT g FROM Groupe g JOIN g.enseignement e WHERE e = :enseignement")
    List<Groupe> findByEnseignement(@Param("enseignement") Enseignement enseignement);


}
