package com.uasz.enseign.WebController.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.EmploiDTO;
import com.uasz.enseign.services.EmploiDuTemps.EmploiService;
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
@RequestMapping("/emplois")
public class EmploiMVCController {

    private final EmploiService emploiService;

    @Autowired
    public EmploiMVCController(EmploiService emploiService) {
        this.emploiService = emploiService;
    }

    // Afficher tous les Emplois
    @GetMapping
    public String getAllEmplois(Model model) {
        List<EmploiDTO> emploiList = emploiService.getAllEmplois();
        model.addAttribute("emploiList", emploiList);
        return "emploiList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un Emploi par ID
    @GetMapping("/{id}")
    public String getEmploiById(@PathVariable Long id, Model model) {
        try {
            EmploiDTO emploiDTO = emploiService.getEmploiById(id);
            model.addAttribute("emploiDTO", emploiDTO);
            return "emploiDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } catch (IllegalArgumentException e) {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouveau Emploi
    @PostMapping
    public String createEmploi(@ModelAttribute @Validated EmploiDTO emploiDTO, Model model) {
        EmploiDTO createdEmploi = emploiService.createEmploi(emploiDTO);
        model.addAttribute("createdEmploi", createdEmploi);
        return "redirect:/emplois/" + createdEmploi.getId();
    }

    // Mettre à jour un Emploi existant par ID
    @PutMapping("/{id}")
    public String updateEmploi(@PathVariable Long id, @ModelAttribute @Validated EmploiDTO emploiDTO, Model model) {
        try {
            EmploiDTO updatedEmploi = emploiService.updateEmploi(id, emploiDTO);
            model.addAttribute("updatedEmploi", updatedEmploi);
            return "redirect:/emplois/" + updatedEmploi.getId();
        } catch (IllegalArgumentException e) {
            // Gérer le cas où l'Emploi n'existe pas
            return "notFound";
        }
    }

    // Supprimer un Emploi par ID
    @DeleteMapping("/{id}")
    public String deleteEmploi(@PathVariable Long id) {
        try {
            emploiService.deleteEmploi(id);
            return "redirect:/emplois";
        } catch (IllegalArgumentException e) {
            // Gérer le cas où l'Emploi n'existe pas
            return "notFound";
        }
    }
}
