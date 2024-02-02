package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.EC; // Importez l'entité plutôt que le DTO
import com.uasz.enseign.model.Maquette.Module;
import com.uasz.enseign.model.Maquette.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ECRepository extends JpaRepository<EC, Long> {
//
//    List<EC> findByLibelle(String libelle);
//
//    List<EC> findByCode(String code);
//
//    List<EC> findByCoefficientGreaterThan(int coefficient);
//
//    List<EC> findByDateCreationAfter(Date date);
//
//    List<EC> findByUe(UE ue);
    List<EC> findByUeId(Long ueId);
    List<EC> findByModuleId(Long moduleId);
    List<EC> findBySemestre_Id(Long semestre_Id);
}
