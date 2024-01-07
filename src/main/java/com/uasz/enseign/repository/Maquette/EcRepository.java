package com.uasz.enseign.repository.Maquette;

import com.uasz.enseign.entities.Maquette.EC;
import com.uasz.enseign.entities.Maquette.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcRepository extends JpaRepository<EC, Long> {

    // Méthode personnalisée pour rechercher les EC associés à une UE donnée
    List<EC> findByUE(UE ue);

    // Vous pouvez ajouter d'autres méthodes personnalisées au besoin

}
