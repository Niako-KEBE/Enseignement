package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.entities.Maquette.Groupe;
import com.uasz.enseign.entities.Repartition.Enseignement;
import com.uasz.enseign.repository.Maquette.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    // Méthode pour ajouter un groupe
    public void ajouterGroupe(Groupe groupe) {
        groupe.saveGroupe(); // Validation du groupe avant de le sauvegarder
        groupeRepository.save(groupe);
    }

    // Méthode pour afficher tous les groupes
    public List<Groupe> afficherTousGroupes() {
        return groupeRepository.findAll();
    }

    // Méthode pour afficher un groupe par son ID
    public Groupe afficherGroupe(Long idGroupe) {
        return groupeRepository.getById(idGroupe);
    }

    // Méthode pour modifier un groupe
    public void modifierGroupe(Groupe groupe) {
        groupe.saveGroupe(); // Validation du groupe avant de le modifier

        // Récupération du groupe à mettre à jour depuis le repository
        Groupe groupeUpdate = groupeRepository.getById(groupe.getIdGroupe());

        // Mise à jour des propriétés du groupe avec les nouvelles valeurs
        groupeUpdate.setLibelle(groupe.getLibelle());
        groupeUpdate.setNumero(groupe.getNumero());
        groupeUpdate.setEffectif(groupe.getEffectif());
        groupeUpdate.setDescription(groupe.getDescription());
        groupeUpdate.setClasse(groupe.getClasse());

        // Sauvegarde du groupe mis à jour dans le repository
        groupeRepository.save(groupeUpdate);
    }

    // Méthode pour supprimer un groupe
    public void supprimerGroupe(Long idGroupe) {
        groupeRepository.deleteById(idGroupe);
    }

    // Méthode pour trouver les enseignements associés à un groupe
    public List<Enseignement> trouverEnseignementsParGroupe(Groupe groupe) {
        return groupeRepository.findEnseignementsByGroupe(groupe);
    }

    // Ajoutez d'autres méthodes personnalisées au besoin
}
