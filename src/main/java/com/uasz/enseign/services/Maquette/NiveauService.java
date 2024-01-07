package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Niveau;
import com.uasz.enseign.entities.Maquette.Formation;
import com.uasz.enseign.repository.Maquette.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {

    @Autowired
    private NiveauRepository niveauRepository;

    // Méthode pour ajouter un niveau
    public void ajouterNiveau(Niveau niveau) {
        niveau.setLibelle(niveau.getLibelle()); // Utilisation de la validation directement depuis la classe Niveau
        niveauRepository.save(niveau);
    }

    // Méthode pour afficher tous les niveaux
    public List<Niveau> afficherTousNiveaux() {
        return niveauRepository.findAll();
    }

    // Méthode pour afficher un niveau par son ID
    public Niveau afficherNiveau(Long idNiveau) {
        return niveauRepository.getById(idNiveau);
    }

    // Méthode pour modifier un niveau
    public void modifierNiveau(Niveau niveau) {
        niveau.setLibelle(niveau.getLibelle()); // Utilisation de la validation directement depuis la classe Niveau

        // Récupération du niveau à mettre à jour depuis le repository
        Niveau niveauUpdate = niveauRepository.getById(niveau.getIdNiveau());

        // Mise à jour des propriétés du niveau avec les nouvelles valeurs
        niveauUpdate.setLibelle(niveau.getLibelle());
        niveauUpdate.setDescription(niveau.getDescription());
        niveauUpdate.setCycle(niveau.getCycle());

        // Sauvegarde du niveau mis à jour dans le repository
        niveauRepository.save(niveauUpdate);
    }

    // Méthode pour supprimer un niveau
    public void supprimerNiveau(Long idNiveau) {
        niveauRepository.deleteById(idNiveau);
    }

    // Méthode pour trouver les formations associées à un niveau
    public List<Formation> trouverFormationsParNiveau(Niveau niveau) {
        return niveauRepository.findFormationsByNiveau(niveau);
    }

    // Ajoutez d'autres méthodes personnalisées au besoin
}
