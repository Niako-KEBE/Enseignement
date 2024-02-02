package com.uasz.enseign.WebController.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SalleDTO;
import com.uasz.enseign.services.EmploiDuTemps.SalleService;
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
@RequestMapping("/salles")
public class SalleMVCController {

    private final SalleService salleService;

    @Autowired
    public SalleMVCController(SalleService salleService) {
        this.salleService = salleService;
    }

    // Afficher toutes les Salles
    @GetMapping
    public String getAllSalles(Model model) {
        List<SalleDTO> salleList = salleService.getAllSalles();
        model.addAttribute("salleList", salleList);
        return "salleList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher une Salle par ID
    @GetMapping("/{id}")
    public String getSalleById(@PathVariable Long id, Model model) {
        SalleDTO salleDTO = salleService.getSalleById(id);
        if (salleDTO != null) {
            model.addAttribute("salleDTO", salleDTO);
            return "salleDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer une nouvelle Salle
    @PostMapping
    public String createSalle(@ModelAttribute @Validated SalleDTO salleDTO, Model model) {
        SalleDTO createdSalle = salleService.createSalle(salleDTO);
        model.addAttribute("createdSalle", createdSalle);
        return "redirect:/salles/" + createdSalle.getId();
    }

    // Mettre à jour une Salle existante par ID
    @PutMapping("/{id}")
    public String updateSalle(@PathVariable Long id, @ModelAttribute @Validated SalleDTO salleDTO, Model model) {
        SalleDTO updatedSalle = salleService.updateSalle(id, salleDTO);
        if (updatedSalle != null) {
            model.addAttribute("updatedSalle", updatedSalle);
            return "redirect:/salles/" + updatedSalle.getId();
        } else {
            // Gérer le cas où la Salle n'existe pas
            return "notFound";
        }
    }

    // Supprimer une Salle par ID
    @DeleteMapping("/{id}")
    public String deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return "redirect:/salles";
    }
}
