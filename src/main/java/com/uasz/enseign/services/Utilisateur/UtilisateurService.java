package com.uasz.enseign.services.Utilisateur;

import com.uasz.enseign.entities.Maquette.UE;
import com.uasz.enseign.entities.Utilisateur.Utilisateur;
import com.uasz.enseign.repository.Utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
//@Service: Cette annotation indique à Spring que la classe UtilisateurService est un service
//et doit être traitée comme tel lors de  la configuration du contexte d'application

public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    //Déclare la méthode getById qui récupère un utilisateur par son identifiant.
    //Appelle la méthode findById du repository pour récupérer un Optional d'utilisateur
    // en fonction de l'identifiant fourni.
    public Utilisateur getById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }


    //es méthodes suivantes (getAllUtilisateurs, saveUtilisateur, deleteUtilisateur) effectuent des
    // opérations similaires en utilisant les méthodes correspondantes du utilisateurRepository.
    public Collection<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    // qui utilise la méthode personnalisée findUesByUtilisateurId du repository pour
    // récupérer les unités d'enseignement associées à un utilisateur.
    public Collection<UE> getUesByUtilisateurId(Long userId) {
        return utilisateurRepository.findUesByUtilisateurId(userId);
    }

    // Ajoutez d'autres méthodes de service au besoin

}
