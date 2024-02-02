package com.uasz.enseign.WebController.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.DeroulementDTO;
import com.uasz.enseign.services.EmploiDuTemps.DeroulementService;
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
@RequestMapping("/deroulements")
public class DeroulementMVCController {

    private final DeroulementService deroulementService;

    @Autowired
    public DeroulementMVCController(DeroulementService deroulementService) {
        this.deroulementService = deroulementService;
    }

    // Afficher tous les Deroulements
    @GetMapping
    public String getAllDeroulements(Model model) {
        List<DeroulementDTO> deroulementList = deroulementService.getAllDeroulements();
        model.addAttribute("deroulementList", deroulementList);
        return "deroulementList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un Deroulement par ID
    @GetMapping("/{id}")
    public String getDeroulementById(@PathVariable Long id, Model model) {
        DeroulementDTO deroulementDTO = deroulementService.getDeroulementById(id);
        if (deroulementDTO != null) {
            model.addAttribute("deroulementDTO", deroulementDTO);
            return "deroulementDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouveau Deroulement
    @PostMapping
    public String createDeroulement(@ModelAttribute @Validated DeroulementDTO deroulementDTO, Model model) {
        DeroulementDTO createdDeroulement = deroulementService.createDeroulement(deroulementDTO);
        model.addAttribute("createdDeroulement", createdDeroulement);
        return "redirect:/deroulements/" + createdDeroulement.getId();
    }

    // Mettre à jour un Deroulement existant par ID
    @PutMapping("/{id}")
    public String updateDeroulement(@PathVariable Long id, @ModelAttribute @Validated DeroulementDTO deroulementDTO, Model model) {
        DeroulementDTO updatedDeroulement = deroulementService.updateDeroulement(id, deroulementDTO);
        if (updatedDeroulement != null) {
            model.addAttribute("updatedDeroulement", updatedDeroulement);
            return "redirect:/deroulements/" + updatedDeroulement.getId();
        } else {
            // Gérer le cas où le Deroulement n'existe pas
            return "notFound";
        }
    }

    // Supprimer un Deroulement par ID
    @DeleteMapping("/{id}")
    public String deleteDeroulement(@PathVariable Long id) {
        deroulementService.deleteDeroulement(id);
        return "redirect:/deroulements";
    }
}
