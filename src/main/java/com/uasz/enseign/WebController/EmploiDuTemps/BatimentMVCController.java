package com.uasz.enseign.WebController.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;
import com.uasz.enseign.services.EmploiDuTemps.BatimentService;
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
@RequestMapping("/batiments")
public class BatimentMVCController {

    private final BatimentService batimentService;

    @Autowired
    public BatimentMVCController(BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    // Afficher tous les Batiments
    @GetMapping
    public String getAllBatiments(Model model) {
        List<BatimentDTO> batimentList = batimentService.getAllBatiments();
        model.addAttribute("batimentList", batimentList);
        return "batimentList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un Batiment par ID
    @GetMapping("/{id}")
    public String getBatimentById(@PathVariable Long id, Model model) {
        BatimentDTO batimentDTO = batimentService.getBatimentById(id);
        if (batimentDTO != null) {
            model.addAttribute("batimentDTO", batimentDTO);
            return "batimentDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouveau Batiment
    @PostMapping
    public String createBatiment(@ModelAttribute @Validated BatimentDTO batimentDTO, Model model) {
        BatimentDTO createdBatiment = batimentService.createBatiment(batimentDTO);
        model.addAttribute("createdBatiment", createdBatiment);
        return "redirect:/batiments/" + createdBatiment.getId();
    }

    // Mettre à jour un Batiment existant par ID
    @PutMapping("/{id}")
    public String updateBatiment(@PathVariable Long id, @ModelAttribute @Validated BatimentDTO batimentDTO, Model model) {
        BatimentDTO updatedBatiment = batimentService.updateBatiment(id, batimentDTO);
        if (updatedBatiment != null) {
            model.addAttribute("updatedBatiment", updatedBatiment);
            return "redirect:/batiments/" + updatedBatiment.getId();
        } else {
            // Gérer le cas où le Batiment n'existe pas
            return "notFound";
        }
    }

    // Supprimer un Batiment par ID
    @DeleteMapping("/{id}")
    public String deleteBatiment(@PathVariable Long id) {
        batimentService.deleteBatiment(id);
        return "redirect:/batiments";
    }
}
