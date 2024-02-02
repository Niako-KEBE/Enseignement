package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.Semestre; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.model.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    List<Semestre> findByLibelle(String libelle);

    @Query("SELECT s FROM Semestre s JOIN s.classes c WHERE c = :classe")
    List<Semestre> findByClasse(@Param("classe") Classe classe);

    @Query("SELECT s FROM Semestre s JOIN s.modules m WHERE m = :module")
    List<Semestre> findByModule(@Param("module") Module module);
}
