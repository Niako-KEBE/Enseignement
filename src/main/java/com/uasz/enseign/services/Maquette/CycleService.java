package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Cycle;
import com.uasz.enseign.entities.Maquette.Niveau;
import com.uasz.enseign.repository.Maquette.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleService {

    @Autowired
    private CycleRepository cycleRepository;

    // Méthode pour ajouter un cycle
    public void ajouterCycle(Cycle cycle) {
        cycle.validateCycle(); // Validation du cycle avant de le sauvegarder
        cycleRepository.save(cycle);
    }

    // Méthode pour afficher tous les cycles
    public List<Cycle> afficherTousCycles() {
        return cycleRepository.findAll();
    }

    // Méthode pour afficher un cycle par son ID
    public Cycle afficherCycle(Long idCycle) {
        return cycleRepository.getById(idCycle);
    }

    // Méthode pour modifier un cycle
    public void modifierCycle(Cycle cycle) {
        cycle.validateCycle(); // Validation du cycle avant de le modifier

        // Récupération du cycle à mettre à jour depuis le repository
        Cycle cycleUpdate = cycleRepository.getById(cycle.getIdCycle());

        // Mise à jour des propriétés du cycle avec les nouvelles valeurs
        cycleUpdate.setLibelle(cycle.getLibelle());
        cycleUpdate.setDescription(cycle.getDescription());

        // Sauvegarde du cycle mis à jour dans le repository
        cycleRepository.save(cycleUpdate);
    }

    // Méthode pour supprimer un cycle
    public void supprimerCycle(Long idCycle) {
        cycleRepository.deleteById(idCycle);
    }

    // Méthode pour trouver les niveaux associés à un cycle
    public List<Niveau> trouverNiveauxParCycle(Cycle cycle) {
        return cycleRepository.findNiveauxByCycle(cycle);
    }

}
