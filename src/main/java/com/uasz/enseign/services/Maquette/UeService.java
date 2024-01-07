package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.EC;
import com.uasz.enseign.entities.Maquette.UE;
import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.repository.Maquette.UeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Déclaration du package pour le service lié à la maquette
@Service
// Annotation indiquant que chaque méthode dans cette classe doit être exécutée dans une transaction
@Transactional
public class UeService {

    // Injection de dépendance du repository UeRepository
    @Autowired
    private UeRepository ueRepository;

    // Méthode pour ajouter une UE
    public void ajouterUE(UE ue) {
        // Sauvegarde de l'UE dans le repository
        ueRepository.save(ue);
    }

    // Méthode pour afficher toutes les UE
    public List<UE> afficherToutUE() {
        // Récupération de toutes les UE à partir du repository
        return ueRepository.findAll();
    }

    // Méthode pour afficher une UE par son ID
    public UE afficherUE(Long id) {
        // Récupération de l'UE par son ID à partir du repository
        return ueRepository.getById(id);
    }

    // Méthode pour modifier une UE
    public void modifierUE(UE ue) {
        // Récupération de l'UE à mettre à jour depuis le repository
        UE ueUpdate = ueRepository.getById(ue.getIdUe());

        // Mise à jour des propriétés de l'UE avec les nouvelles valeurs
        ueUpdate.setCode(ue.getCode());
        ueUpdate.setLibelle(ue.getLibelle());
        ueUpdate.setCredit(ue.getCredit());
        ueUpdate.setCoefficient(ue.getCoefficient());
        ueUpdate.setDescription(ue.getDescription());
        ueUpdate.setUtilisateur(ue.getUtilisateur());

        // Sauvegarde de l'UE mise à jour dans le repository
        ueRepository.save(ueUpdate);
    }

    // Méthode pour supprimer une UE
    public void supprimerUE(UE ue) {
        // Suppression de l'UE à partir du repository
        ueRepository.delete(ue);
    }

    // Méthode pour afficher les EC associés à une UE
    public List<EC> afficherLesEC(UE ue) {
        // Récupération des EC associés à l'UE depuis le repository
        return ueRepository.findEcsByUE(ue);
    }
   // Méthode pour afficher les modules associés à une UE
    public List<Module> afficherLesModules(UE ue) {
        // Récupération des modules associés à l'UE depuis le repository
        return ueRepository.findModulesByUE(ue);
    }

}
