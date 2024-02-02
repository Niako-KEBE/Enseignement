package com.uasz.enseign.WebController.Utilisateur;

import com.uasz.enseign.dto.Utilisateur.UtilisateurDTO;
import com.uasz.enseign.services.Utilisateur.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurMVCController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurMVCController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // Afficher tous les Utilisateurs
    @GetMapping
    public String getAllUtilisateurs(Model model) {
        List<UtilisateurDTO> utilisateurList = utilisateurService.getAllUtilisateurs();
        model.addAttribute("utilisateurList", utilisateurList);
        return "utilisateurList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un Utilisateur par ID
    @GetMapping("/{id}")
    public String getUtilisateurById(@PathVariable Long id, Model model) {
        UtilisateurDTO utilisateurDTO = utilisateurService.getUtilisateurById(id);
        if (utilisateurDTO != null) {
            model.addAttribute("utilisateurDTO", utilisateurDTO);
            return "utilisateurDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouvel Utilisateur
    @PostMapping
    public String createUtilisateur(@ModelAttribute @Validated UtilisateurDTO utilisateurDTO, Model model) {
        UtilisateurDTO createdUtilisateur = utilisateurService.createUtilisateur(utilisateurDTO);
        model.addAttribute("createdUtilisateur", createdUtilisateur);
        return "redirect:/utilisateurs/" + createdUtilisateur.getId();
    }

    // Mettre à jour un Utilisateur existant par ID
    @PutMapping("/{id}")
    public String updateUtilisateur(@PathVariable Long id, @ModelAttribute @Validated UtilisateurDTO utilisateurDTO, Model model) {
        UtilisateurDTO updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDTO);
        if (updatedUtilisateur != null) {
            model.addAttribute("updatedUtilisateur", updatedUtilisateur);
            return "redirect:/utilisateurs/" + updatedUtilisateur.getId();
        } else {
            // Gérer le cas où l'Utilisateur n'existe pas
            return "notFound";
        }
    }

    // Supprimer un Utilisateur par ID
    @DeleteMapping("/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs";
    }
}
