package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Filiere;
import com.uasz.enseign.entities.Maquette.Formation;
import com.uasz.enseign.repository.Maquette.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    // Méthode pour ajouter une filière
    public void ajouterFiliere(Filiere filiere) {
        filiere.saveFiliere(); // Validation de la filière avant de la sauvegarder
        filiereRepository.save(filiere);
    }

    // Méthode pour afficher toutes les filières
    public List<Filiere> afficherToutesFilieres() {
        return filiereRepository.findAll();
    }

    // Méthode pour afficher une filière par son ID
    public Filiere afficherFiliere(Long idFiliere) {
        return filiereRepository.getById(idFiliere);
    }

    // Méthode pour modifier une filière
    public void modifierFiliere(Filiere filiere) {
        filiere.saveFiliere(); // Validation de la filière avant de la modifier

        // Récupération de la filière à mettre à jour depuis le repository
        Filiere filiereUpdate = filiereRepository.getById(filiere.getIdFiliere());

        // Mise à jour des propriétés de la filière avec les nouvelles valeurs
        filiereUpdate.setLibelle(filiere.getLibelle());
        filiereUpdate.setDescription(filiere.getDescription());

        // Sauvegarde de la filière mise à jour dans le repository
        filiereRepository.save(filiereUpdate);
    }

    // Méthode pour supprimer une filière
    public void supprimerFiliere(Long idFiliere) {
        filiereRepository.deleteById(idFiliere);
    }

    // Méthode pour trouver les formations associées à une filière
    public List<Formation> trouverFormationsParFiliere(Long filiereId) {
        return filiereRepository.findFormationsByFiliereId(filiereId);
    }
}
