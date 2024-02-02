package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Module; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.UE;
import com.uasz.enseign.model.Maquette.EC;
import com.uasz.enseign.model.Maquette.Semestre;
import com.uasz.enseign.model.Maquette.Enseignement;
import com.uasz.enseign.model.Maquette.Maquette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findByNom(String nom);

    List<Module> findByUe(UE ue);

    List<Module> findByEc(EC ec);

    List<Module> findBySemestre(Semestre semestre);

    List<Module> findByMaquette(Maquette maquette);

    @Query("SELECT m FROM Module m JOIN m.enseignements e WHERE e = :enseignement")
    List<Module> findByEnseignement(@Param("enseignement") Enseignement enseignement);

}
