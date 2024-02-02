package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.FormationDTO;
import com.uasz.enseign.services.Maquette.FormationService;
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
@RequestMapping("/formations")
public class FormationMvcController {

    private final FormationService formationService;

    @Autowired
    public FormationMvcController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public String getAllFormations(Model model) {
        List<FormationDTO> formations = formationService.getAllFormations();
        model.addAttribute("formations", formations);
        return "responsablePedagogique/formationList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getFormationById(@PathVariable Long id, Model model) {
        FormationDTO formation = formationService.getFormationById(id);
        if (formation != null) {
            model.addAttribute("formation", formation);
            return "responsablePedagogique/formationDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createFormation(@ModelAttribute FormationDTO formationDTO) {
        FormationDTO createdFormation = formationService.createFormation(formationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/formations/" + createdFormation.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormation(@PathVariable Long id, @ModelAttribute FormationDTO formationDTO) {
        FormationDTO updatedFormation = formationService.updateFormation(id, formationDTO);
        if (updatedFormation != null) {
            return ResponseEntity.ok("redirect:/formations/" + updatedFormation.getId());
        } else {
            // Gérer le cas où la Formation n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formation not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/formations");
    }

    @GetMapping("/filiere/{filiereId}")
    public String getFormationsByFiliereId(@PathVariable Long filiereId, Model model) {
        List<FormationDTO> formations = formationService.getFormationsByFiliereId(filiereId);
        model.addAttribute("formations", formations);
        return "responsablePedagogique/formationList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/niveau/{niveauId}")
    public String getFormationsByNiveauId(@PathVariable Long niveauId, Model model) {
        List<FormationDTO> formations = formationService.getFormationsByNiveauId(niveauId);
        model.addAttribute("formations", formations);
        return "responsablePedagogique/formationList"; // le nom de la vue, à définir dans vos configurations
    }
}
