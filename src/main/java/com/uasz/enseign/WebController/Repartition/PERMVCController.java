package com.uasz.enseign.WebController.Repartition;

import com.uasz.enseign.dto.Repartition.PERDTO;
import com.uasz.enseign.services.Repartition.PERService;
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
@RequestMapping("/repartition/pers")
public class PERMVCController {

    private final PERService perService;

    @Autowired
    public PERMVCController(PERService perService) {
        this.perService = perService;
    }

    // Afficher tous les PERs
    @GetMapping
    public String getAllPERs(Model model) {
        List<PERDTO> perList = perService.getAllPERs();
        model.addAttribute("perList", perList);
        return "perList"; // Définissez le nom de la vue, configurez selon vos besoins
    }

    // Afficher un PER par ID
    @GetMapping("/{id}")
    public String getPERById(@PathVariable Long id, Model model) {
        PERDTO perDTO = perService.getPERById(id);
        if (perDTO != null) {
            model.addAttribute("perDTO", perDTO);
            return "perDetails"; // Définissez le nom de la vue, configurez selon vos besoins
        } else {
            return "notFound"; // Définissez le nom de la vue pour les ressources non trouvées
        }
    }

    // Créer un nouveau PER
    @PostMapping
    public String createPER(@ModelAttribute @Validated PERDTO perDTO, Model model) {
        PERDTO createdPER = perService.createPER(perDTO);
        model.addAttribute("createdPER", createdPER);
        return "redirect:/repartition/pers/" + createdPER.getId();
    }

    // Mettre à jour un PER existant par ID
    @PutMapping("/{id}")
    public String updatePER(@PathVariable Long id, @ModelAttribute @Validated PERDTO perDTO, Model model) {
        PERDTO updatedPER = perService.updatePER(id, perDTO);
        if (updatedPER != null) {
            model.addAttribute("updatedPER", updatedPER);
            return "redirect:/repartition/pers/" + updatedPER.getId();
        } else {
            // Gérer le cas où le PER n'existe pas
            return "notFound";
        }
    }

    // Supprimer un PER par ID
    @DeleteMapping("/{id}")
    public String deletePER(@PathVariable Long id) {
        perService.deletePER(id);
        return "redirect:/repartition/pers";
    }

}
