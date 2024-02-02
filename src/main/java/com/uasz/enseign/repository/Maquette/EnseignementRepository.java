package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.model.Maquette.Enseignement;
import com.uasz.enseign.model.Maquette.Groupe;
import com.uasz.enseign.model.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {

    List<Enseignement> findByLibelle(String libelle);

    List<Enseignement> findByClasse(Classe classe);

    List<Enseignement> findByGroupe(Groupe groupe);

}
