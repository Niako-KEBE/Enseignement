package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Classe;
import com.uasz.enseign.entities.Maquette.Formation;
import com.uasz.enseign.entities.Maquette.Maquette;
import com.uasz.enseign.repository.Maquette.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    // Méthode pour ajouter une formation
    public void ajouterFormation(Formation formation) {
        formation.saveFormation(); // Validation de la formation avant de la sauvegarder
        formationRepository.save(formation);
    }

    // Méthode pour afficher toutes les formations
    public List<Formation> afficherToutesFormations() {
        return formationRepository.findAll();
    }

    // Méthode pour afficher une formation par son ID
    public Formation afficherFormation(Long idFormation) {
        return formationRepository.getById(idFormation);
    }

    // Méthode pour modifier une formation
    public void modifierFormation(Formation formation) {
        formation.saveFormation(); // Validation de la formation avant de la modifier

        // Récupération de la formation à mettre à jour depuis le repository
        Formation formationUpdate = formationRepository.getById(formation.getIdFormation());

        // Mise à jour des propriétés de la formation avec les nouvelles valeurs
        formationUpdate.setLibelle(formation.getLibelle());
        formationUpdate.setDescription(formation.getDescription());
        formationUpdate.setNiveau(formation.getNiveau());
        formationUpdate.setFiliere(formation.getFiliere());

        // Sauvegarde de la formation mise à jour dans le repository
        formationRepository.save(formationUpdate);
    }

    // Méthode pour supprimer une formation
    public void supprimerFormation(Long idFormation) {
        formationRepository.deleteById(idFormation);
    }

    // Méthode pour trouver des formations par libellé
    public List<Formation> trouverFormationsParLibelle(String libelle) {
        return formationRepository.findByLibelleContainingIgnoreCase(libelle);
    }

    // Méthode pour trouver des formations par filière
    public List<Formation> trouverFormationsParFiliere(Long filiereId) {
        return formationRepository.findByFiliereId(filiereId);
    }

    // Méthode pour trouver des formations par classe
    public List<Formation> trouverFormationsParClasse(Long classeId) {
        return formationRepository.findByClasseId(classeId);
    }

    // Méthode pour trouver des formations par maquette
    public List<Formation> trouverFormationsParMaquette(Long maquetteId) {
        return formationRepository.findByMaquetteId(maquetteId);
    }

    // Méthode pour trouver des formations avec une description non vide
    public List<Formation> trouverFormationsAvecDescription() {
        return formationRepository.findFormationsWithDescription();
    }

    // Méthode pour obtenir les classes associées à une formation
    public List<Classe> obtenirClassesParFormation(Formation formation) {
        // Récupération de la formation par son ID
        return formationRepository.getById(formation.getIdFormation()).getClasses();
    }

    // Méthode pour obtenir la maquette associée à une formation
    public Maquette obtenirMaquetteParFormation(Formation formation) {
        // Récupération de la formation par son ID
        return formationRepository.getById(formation.getIdFormation()).getMaquette();
    }
}
