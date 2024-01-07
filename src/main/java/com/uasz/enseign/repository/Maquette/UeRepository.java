package com.uasz.enseign.repository.Maquette;


import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.entities.Maquette.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uasz.enseign.entities.Maquette.EC;

import java.util.List;
import java.util.Optional;

@Repository
public interface UeRepository extends JpaRepository<UE, Long> {

    // Méthode pour rechercher une UE par son code
    Optional<UE> findByCode(String code);

    // Méthode pour rechercher les UE associées à un utilisateur donné
    List<UE> findByUtilisateur_Id(Long utilisateurId);

    // Méthode pour rechercher les UE ayant un certain crédit
    List<UE> findByCredit(int credit);

    // Méthode pour rechercher les UE ayant un coefficient supérieur à une valeur donnée
    List<UE> findByCoefficientGreaterThan(int coefficient);

    // Méthode personnalisée pour rechercher les EC associés à une UE donnée
    @Query("SELECT e FROM EC e WHERE e.ue = ?1")
    List<EC> findEcsByUE(UE ue);

    // Méthode personnalisée pour rechercher les UE par libellé en utilisant la convention de nommage de Spring Data JPA
    List<UE> findByLibelleContainingIgnoreCase(String libelle);

    // Méthode personnalisée pour rechercher les modules associés à une UE donnée
    @Query("SELECT m FROM Module m WHERE m.ue = ?1")
    List<Module> findModulesByUE(UE ue);
}
