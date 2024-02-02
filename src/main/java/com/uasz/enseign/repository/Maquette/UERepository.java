package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.model.Maquette.UE;
import com.uasz.enseign.model.Maquette.EC;
import com.uasz.enseign.model.Maquette.Module;
import com.uasz.enseign.model.Utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UERepository extends JpaRepository<UE, Long> {

    List<UE> findByLibelle(String libelle);

    List<UE> findByCode(String code);

    List<UE> findByDescription(String description);

    List<UE> findByEcsContaining(EC ec);
    List<UE> findByCreatedAtAfter(Date date);

    List<UE> findByUtilisateur(Utilisateur utilisateur);

    List<UE> findByCreditGreaterThan(int credit);

    List<UE> findByCoefficientGreaterThan(int coefficient);

    List<UE> findByUtilisateur_Id(Long utilisateurId);

    @Query("SELECT ue FROM UE ue JOIN ue.module m WHERE m = :module")
    List<UE> findByModule(@Param("module") Module module);

}
