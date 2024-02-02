package com.uasz.enseign.WebController.Repartition;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;
import com.uasz.enseign.services.Repartition.RepartitionService;
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
@RequestMapping("/repartition")
public class RepartitionMVCController {

    private final RepartitionService repartitionService;

    @Autowired
    public RepartitionMVCController(RepartitionService repartitionService) {
        this.repartitionService = repartitionService;
    }

    // Afficher toutes les Repartitions
    @GetMapping
    public String getAllRepartitions(Model model) {
        List<RepartitionDTO> repartitionList = repartitionService.getAllRepartitions();
        model.addAttribute("repartitionList", repartitionList);
        return "repartitionList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher une Repartition par ID
    @GetMapping("/{id}")
    public String getRepartitionById(@PathVariable Long id, Model model) {
        RepartitionDTO repartitionDTO = repartitionService.getRepartitionById(id);
        if (repartitionDTO != null) {
            model.addAttribute("repartitionDTO", repartitionDTO);
            return "repartitionDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer une nouvelle Repartition
    @PostMapping
    public String createRepartition(@ModelAttribute @Validated RepartitionDTO repartitionDTO, Model model) {
        RepartitionDTO createdRepartition = repartitionService.createRepartition(repartitionDTO);
        model.addAttribute("createdRepartition", createdRepartition);
        return "redirect:/repartition/" + createdRepartition.getId();
    }

    // Mettre à jour une Repartition existante par ID
    @PutMapping("/{id}")
    public String updateRepartition(@PathVariable Long id, @ModelAttribute @Validated RepartitionDTO repartitionDTO, Model model) {
        RepartitionDTO updatedRepartition = repartitionService.updateRepartition(id, repartitionDTO);
        if (updatedRepartition != null) {
            model.addAttribute("updatedRepartition", updatedRepartition);
            return "redirect:/repartition/" + updatedRepartition.getId();
        } else {
            // Gérer le cas où la Repartition n'existe pas
            return "notFound";
        }
    }

    // Supprimer une Repartition par ID
    @DeleteMapping("/{id}")
    public String deleteRepartition(@PathVariable Long id) {
        repartitionService.deleteRepartition(id);
        return "redirect:/repartition";
    }
}
