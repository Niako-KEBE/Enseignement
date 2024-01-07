package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Classe;
import com.uasz.enseign.entities.Maquette.Groupe;
import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.repository.Maquette.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    // Méthode pour ajouter une classe
    public void ajouterClasse(Classe classe) {
        classe.validateClasse(); // Validation de la classe avant de la sauvegarder
        classeRepository.save(classe);
    }

    // Méthode pour afficher toutes les classes
    public List<Classe> afficherToutesClasses() {
        return classeRepository.findAll();
    }

    // Méthode pour afficher une classe par son ID
    public Classe afficherClasse(Long idClasse) {
        return classeRepository.getById(idClasse);
    }
    // Méthode pour modifier une classe
    public void modifierClasse(Classe classe) {
        // Validation de la classe avant de la modifier
        classe.validateClasse();

        // Récupération de la classe à mettre à jour depuis le repository
        Classe classeUpdate = classeRepository.getById(classe.getIdClasse());

        // Mise à jour des propriétés de la classe avec les nouvelles valeurs
        classeUpdate.setLibelle(classe.getLibelle());
        classeUpdate.setEffectif(classe.getEffectif());
        classeUpdate.setNbreGroupe(classe.getNbreGroupe());
        classeUpdate.setDescription(classe.getDescription());
        classeUpdate.setSemestre(classe.getSemestre());
        classeUpdate.setFormation(classe.getFormation());

        // Sauvegarde de la classe mise à jour dans le repository
        classeRepository.save(classeUpdate);
    }
    // Méthode pour supprimer une classe
    public void supprimerClasse(Long idClasse) {
        classeRepository.deleteById(idClasse);
    }

    // Méthode pour trouver une classe par son libellé
    public Optional<Classe> trouverParLibelle(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }

    // Méthode pour trouver les classes associées à un semestre
    public List<Classe> trouverParSemestre(Long semestreId) {
        return classeRepository.findBySemestre_Id(semestreId);
    }

    // Méthode pour trouver les classes ayant un certain effectif
    public List<Classe> trouverParEffectif(int effectif) {
        return classeRepository.findByEffectif(effectif);
    }

    // Méthode pour trouver les classes ayant un certain nombre de groupes
    public List<Classe> trouverParNbreGroupe(int nbreGroupe) {
        return classeRepository.findByNbreGroupe(nbreGroupe);
    }

    // Méthode pour trouver les classes par description
    public List<Classe> trouverParDescription(String description) {
        return classeRepository.findByDescriptionContainingIgnoreCase(description);
    }

    // Méthode pour trouver les enseignements associés à une classe
    public List<Enseignement> trouverEnseignementsParClasse(Classe classe) {
        return classeRepository.findEnseignementsByClasse(classe);
    }
    // Méthode pour obtenir les groupes associés à une classe
    public List<Groupe> obtenirGroupesParClasse(Classe classe) {
        // Récupération de la classe par son ID
        return classeRepository.findGroupesByClasse(classe);
    }

}

