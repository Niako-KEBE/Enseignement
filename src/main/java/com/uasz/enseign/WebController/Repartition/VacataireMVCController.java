package com.uasz.enseign.WebController.Repartition;
import com.uasz.enseign.dto.Repartition.VacataireDTO;
import com.uasz.enseign.services.Repartition.VacataireService;
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
@RequestMapping("/vacataires")
public class VacataireMVCController {

    private final VacataireService vacataireService;

    @Autowired
    public VacataireMVCController(VacataireService vacataireService) {
        this.vacataireService = vacataireService;
    }

    // Afficher tous les Vacataires
    @GetMapping
    public String getAllVacataires(Model model) {
        List<VacataireDTO> vacataireList = vacataireService.getAllVacataires();
        model.addAttribute("vacataireList", vacataireList);
        return "vacataireList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un Vacataire par ID
    @GetMapping("/{id}")
    public String getVacataireById(@PathVariable Long id, Model model) {
        VacataireDTO vacataireDTO = vacataireService.getVacataireById(id);
        if (vacataireDTO != null) {
            model.addAttribute("vacataireDTO", vacataireDTO);
            return "vacataireDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouveau Vacataire
    @PostMapping
    public String createVacataire(@ModelAttribute @Validated VacataireDTO vacataireDTO, Model model) {
        VacataireDTO createdVacataire = vacataireService.createVacataire(vacataireDTO);
        model.addAttribute("createdVacataire", createdVacataire);
        return "redirect:/vacataires/" + createdVacataire.getId();
    }

    // Mettre à jour un Vacataire existant par ID
    @PutMapping("/{id}")
    public String updateVacataire(@PathVariable Long id, @ModelAttribute @Validated VacataireDTO vacataireDTO, Model model) {
        VacataireDTO updatedVacataire = vacataireService.updateVacataire(id, vacataireDTO);
        if (updatedVacataire != null) {
            model.addAttribute("updatedVacataire", updatedVacataire);
            return "redirect:/vacataires/" + updatedVacataire.getId();
        } else {
            // Gérer le cas où le Vacataire n'existe pas
            return "notFound";
        }
    }

    // Supprimer un Vacataire par ID
    @DeleteMapping("/{id}")
    public String deleteVacataire(@PathVariable Long id) {
        vacataireService.deleteVacataire(id);
        return "redirect:/vacataires";
    }
}
