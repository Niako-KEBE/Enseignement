package com.uasz.enseign.WebController.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import com.uasz.enseign.services.EmploiDuTemps.SeanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@Controller
@RequestMapping("/seances")
public class SeanceMVCController {

    private final SeanceService seanceService;

    @Autowired
    public SeanceMVCController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    // Afficher toutes les Seances
    @GetMapping
    public String getAllSeances(Model model) {
        List<SeanceDTO> seanceList = seanceService.getAllSeances();
        model.addAttribute("seanceList", seanceList);
        return "seanceList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher une Seance par ID
    @GetMapping("/{id}")
    public String getSeanceById(@PathVariable Long id, Model model) {
        SeanceDTO seanceDTO = seanceService.getSeanceById(id);
        if (seanceDTO != null) {
            model.addAttribute("seanceDTO", seanceDTO);
            return "seanceDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer une nouvelle Seance
    @PostMapping
    public String createSeance(@ModelAttribute @Validated SeanceDTO seanceDTO, Model model) {
        SeanceDTO createdSeance = seanceService.createSeance(seanceDTO);
        model.addAttribute("createdSeance", createdSeance);
        return "redirect:/seances/" + createdSeance.getId();
    }

    // Mettre à jour une Seance existante par ID
    @PutMapping("/{id}")
    public String updateSeance(@PathVariable Long id, @ModelAttribute @Validated SeanceDTO seanceDTO, Model model) {
        SeanceDTO updatedSeance = seanceService.updateSeance(id, seanceDTO);
        if (updatedSeance != null) {
            model.addAttribute("updatedSeance", updatedSeance);
            return "redirect:/seances/" + updatedSeance.getId();
        } else {
            // Gérer le cas où la Seance n'existe pas
            return "notFound";
        }
    }

    // Supprimer une Seance par ID
    @DeleteMapping("/{id}")
    public String deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return "redirect:/seances";
    }
}
