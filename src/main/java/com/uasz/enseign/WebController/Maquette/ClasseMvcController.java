package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import com.uasz.enseign.services.Maquette.ClasseService;
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
@RequestMapping("/classes")
public class ClasseMvcController {

    private final ClasseService classeService;

    @Autowired
    public ClasseMvcController(ClasseService classeService) {
        this.classeService = classeService;
    }

    // Endpoint pour afficher toutes les classes
    @GetMapping
    public String getAllClasses(Model model) {
        // Récupère la liste de toutes les classes depuis le service
        List<ClasseDTO> classes = classeService.getAllClasses();
        // Ajoute la liste au modèle pour être utilisée dans la vue
        model.addAttribute("classes", classes);
        // Retourne le nom de la vue (classeList.html par exemple)
        return "responsablePedagogique/classeList"; // le nom de la vue, à définir dans vos configurations
    }

    // Endpoint pour afficher les détails d'une classe par son ID
    @GetMapping("/{id}")
    public String getClasseById(@PathVariable Long id, Model model) {
        // Récupère la classe par son ID depuis le service
        ClasseDTO classe = classeService.getClasseById(id);
        // Vérifie si la classe existe
        if (classe != null) {
            // Ajoute la classe au modèle pour être utilisée dans la vue
            model.addAttribute("classe", classe);
            // Retourne le nom de la vue (classeDetails.html par exemple)
            return "responsablePedagogique/classeDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            // Si la classe n'est pas trouvée, retourne la vue pour les ressources non trouvées
            return "error/403.html"; // le nom de la vue pour les ressources non trouvées
        }
    }
    // Endpoint pour afficher le formulaire de création d'une nouvelle classe
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        // Vous pouvez ajouter des éléments supplémentaires au modèle si nécessaire
        return "responsablePedagogique/createClasseForm"; // Le nom de la vue pour le formulaire de création
    }

    // Endpoint pour traiter la création d'une nouvelle classe
    @PostMapping("/new")
    public String createClasse(@ModelAttribute ClasseDTO classeDTO) {
        ClasseDTO createdClasse = classeService.createClasse(classeDTO);
        // Redirige vers la page de détails de la nouvelle classe
        return "redirect:/classes/" + createdClasse.getId();
    }

    // Endpoint pour afficher le formulaire de mise à jour d'une classe existante
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        ClasseDTO existingClasse = classeService.getClasseById(id);
        model.addAttribute("classe", existingClasse);
        // Vous pouvez ajouter des éléments supplémentaires au modèle si nécessaire
        return "responsablePedagogique/updateClasseForm"; // Le nom de la vue pour le formulaire de mise à jour
    }

    // Endpoint pour traiter la mise à jour d'une classe existante
    @PostMapping("/{id}/edit")
    public String updateClasse(@PathVariable Long id, @ModelAttribute ClasseDTO classeDTO) {
        ClasseDTO updatedClasse = classeService.updateClasse(id, classeDTO);
        // Redirige vers la page de détails de la classe mise à jour
        return "redirect:/classes/" + updatedClasse.getId();
    }

    // Endpoint pour supprimer une classe
    @GetMapping("/{id}/delete")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        // Redirige vers la liste de toutes les classes après la suppression
        return "redirect:/classes";
    }
}

