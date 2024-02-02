package com.uasz.enseign.WebController.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.services.Repartition.EnseignantService;
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
@RequestMapping("/enseignants")
public class EnseignantMvcController {

    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantMvcController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public String getAllEnseignants(Model model) {
        List<EnseignantDTO> enseignants = enseignantService.getAllEnseignants();
        model.addAttribute("enseignants", enseignants);
        return "enseignantList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getEnseignantById(@PathVariable Long id, Model model) {
        EnseignantDTO enseignant = enseignantService.getEnseignantById(id);
        if (enseignant != null) {
            model.addAttribute("enseignant", enseignant);
            return "enseignantDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createEnseignant(@ModelAttribute @Validated EnseignantDTO enseignantDTO) {
        EnseignantDTO createdEnseignant = enseignantService.createEnseignant(enseignantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/enseignants/" + createdEnseignant.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnseignant(@PathVariable Long id, @ModelAttribute @Validated EnseignantDTO enseignantDTO) {
        EnseignantDTO updatedEnseignant = enseignantService.updateEnseignant(id, enseignantDTO);
        if (updatedEnseignant != null) {
            return ResponseEntity.ok("redirect:/enseignants/" + updatedEnseignant.getId());
        } else {
            // Gérer le cas où l'enseignant n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enseignant not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/enseignants");
    }
}
