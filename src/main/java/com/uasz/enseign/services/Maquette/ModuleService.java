package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.repository.Maquette.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Méthode pour ajouter un module
    public void ajouterModule(Module module) {
        module.setCours(module.getCours()); // Utilisation de la validation directement depuis la classe Module
        module.setDuree(module.getDuree()); // Utilisation de la validation directement depuis la classe Module
        module.setObjectifs(module.getObjectifs()); // Utilisation de la validation directement depuis la classe Module
        moduleRepository.save(module);
    }

    // Méthode pour afficher tous les modules
    public List<Module> afficherTousModules() {
        return moduleRepository.findAll();
    }

    // Méthode pour afficher un module par son ID
    public Module afficherModule(Long idModule) {
        return moduleRepository.getById(idModule);
    }

    // Méthode pour modifier un module
    public void modifierModule(Module module) {
        module.setCours(module.getCours()); // Utilisation de la validation directement depuis la classe Module
        module.setDuree(module.getDuree()); // Utilisation de la validation directement depuis la classe Module
        module.setObjectifs(module.getObjectifs()); // Utilisation de la validation directement depuis la classe Module

        // Récupération du module à mettre à jour depuis le repository
        Module moduleUpdate = moduleRepository.getById(module.getIdModule());

        // Mise à jour des propriétés du module avec les nouvelles valeurs
        moduleUpdate.setLibelle(module.getLibelle());
        moduleUpdate.setCours(module.getCours());
        moduleUpdate.setDuree(module.getDuree());
        moduleUpdate.setObjectifs(module.getObjectifs());
        moduleUpdate.setDescription(module.getDescription());
        moduleUpdate.setEc(module.getEc());
        moduleUpdate.setUe(module.getUe());
        moduleUpdate.setMaquette(module.getMaquette());
        moduleUpdate.setSemestre(module.getSemestre());

        // Sauvegarde du module mis à jour dans le repository
        moduleRepository.save(moduleUpdate);
    }

    // Méthode pour supprimer un module
    public void supprimerModule(Long idModule) {
        moduleRepository.deleteById(idModule);
    }

    // Méthode pour trouver les enseignements associés à un module
    public List<Enseignement> trouverEnseignementsParModule(Module module) {
        return moduleRepository.findEnseignementsByModule(module);
    }

    // Ajoutez d'autres méthodes personnalisées au besoin
}
