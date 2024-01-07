package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.EC;
import com.uasz.enseign.entities.Maquette.UE;
import com.uasz.enseign.repository.Maquette.EcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Déclaration du package pour le service lié à la maquette
@Service
public class EcService {

    // Injection de dépendance du repository EcRepository
    @Autowired
    private EcRepository ecRepository;

    // Méthode pour ajouter un EC
    public void ajouterEC(EC ec) {
        // Validation de l'EC avant de le sauvegarder
         ec.validateEC();
        // Sauvegarde de l'EC dans le repository
        ecRepository.save(ec);
    }

    // Méthode pour afficher tous les EC
    public List<EC> afficherTousEC() {
        // Récupération de tous les EC à partir du repository
        return ecRepository.findAll();
    }

    // Méthode pour afficher un EC par son ID
    public EC afficherEC(Long idEc) {
        // Récupération de l'EC par son ID à partir du repository
        return ecRepository.getById(idEc);
    }

    // Méthode pour modifier un EC
    public void modifierEC(EC ec) {
        // Validation de l'EC avant de le modifier
        ec.validateEC();
        // Mise à jour de l'EC dans le repository
        ecRepository.save(ec);
    }

    // Méthode pour supprimer un EC
    public void supprimerEC(Long idEc) {
        // Suppression de l'EC à partir du repository
        ecRepository.deleteById(idEc);
    }

    // Méthode pour afficher les EC associés à une UE
    public List<EC> afficherLesECByUE(UE ue) {
        // Récupération des EC associés à l'UE depuis le repository
        return ecRepository.findByUE(ue);
    }
}