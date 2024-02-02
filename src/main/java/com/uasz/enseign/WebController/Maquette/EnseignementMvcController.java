package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.EnseignementDTO;
import com.uasz.enseign.services.Maquette.EnseignementService;
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
@RequestMapping("/enseignements")
public class EnseignementMvcController {

    private final EnseignementService enseignementService;

    @Autowired
    public EnseignementMvcController(EnseignementService enseignementService) {
        this.enseignementService = enseignementService;
    }

    @GetMapping
    public String getAllEnseignements(Model model) {
        List<EnseignementDTO> enseignements = enseignementService.getAllEnseignements();
        model.addAttribute("enseignements", enseignements);
        return "enseignementList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getEnseignementById(@PathVariable Long id, Model model) {
        EnseignementDTO enseignement = enseignementService.getEnseignementById(id);
        if (enseignement != null) {
            model.addAttribute("enseignement", enseignement);
            return "enseignementDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createEnseignement(@ModelAttribute EnseignementDTO enseignementDTO) {
        EnseignementDTO createdEnseignement = enseignementService.createEnseignement(enseignementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/enseignements/" + createdEnseignement.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnseignement(@PathVariable Long id, @ModelAttribute EnseignementDTO enseignementDTO) {
        EnseignementDTO updatedEnseignement = enseignementService.updateEnseignement(id, enseignementDTO);
        if (updatedEnseignement != null) {
            return ResponseEntity.ok("redirect:/enseignements/" + updatedEnseignement.getId());
        } else {
            // Gérer le cas où l'Enseignement n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enseignement not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignement(@PathVariable Long id) {
        enseignementService.deleteEnseignement(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/enseignements");
    }

    @GetMapping("/classe/{classeId}")
    public String getEnseignementsByClasseId(@PathVariable Long classeId, Model model) {
        List<EnseignementDTO> enseignements = enseignementService.getEnseignementsByClasseId(classeId);
        model.addAttribute("enseignements", enseignements);
        return "enseignementList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/groupe/{groupeId}")
    public String getEnseignementsByGroupeId(@PathVariable Long groupeId, Model model) {
        List<EnseignementDTO> enseignements = enseignementService.getEnseignementsByGroupeId(groupeId);
        model.addAttribute("enseignements", enseignements);
        return "enseignementList"; // le nom de la vue, à définir dans vos configurations
    }
}
