package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Maquette;
import com.uasz.enseign.entities.Maquette.Module;
import com.uasz.enseign.repository.Maquette.MaquetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquetteService {

    @Autowired
    private MaquetteRepository maquetteRepository;

    // Méthode pour ajouter une maquette
    public void ajouterMaquette(Maquette maquette) {
        maquette.saveMaquette(); // Validation de la maquette avant de la sauvegarder
        maquetteRepository.save(maquette);
    }

    // Méthode pour afficher toutes les maquettes
    public List<Maquette> afficherToutesMaquettes() {
        return maquetteRepository.findAll();
    }

    // Méthode pour afficher une maquette par son ID
    public Maquette afficherMaquette(Long idMaquette) {
        return maquetteRepository.getById(idMaquette);
    }

    // Méthode pour modifier une maquette
    public void modifierMaquette(Maquette maquette) {
        maquette.saveMaquette(); // Validation de la maquette avant de la modifier

        // Récupération de la maquette à mettre à jour depuis le repository
        Maquette maquetteUpdate = maquetteRepository.getById(maquette.getIdMaquette());

        // Mise à jour des propriétés de la maquette avec les nouvelles valeurs
        maquetteUpdate.setLibelle(maquette.getLibelle());
        maquetteUpdate.setDescription(maquette.getDescription());

        // Sauvegarde de la maquette mise à jour dans le repository
        maquetteRepository.save(maquetteUpdate);
    }

    // Méthode pour supprimer une maquette
    public void supprimerMaquette(Long idMaquette) {
        maquetteRepository.deleteById(idMaquette);
    }

    // Méthode pour trouver les maquettes associées à un module
    public List<Maquette> trouverMaquettesParModule(Module module) {
        return maquetteRepository.findByModule(module);
    }

    // Ajoutez d'autres méthodes personnalisées au besoin
}
