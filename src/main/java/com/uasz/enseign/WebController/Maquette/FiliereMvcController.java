package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.FiliereDTO;
import com.uasz.enseign.services.Maquette.FiliereService;
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
@RequestMapping("/filieres")
public class FiliereMvcController {

    private final FiliereService filiereService;

    @Autowired
    public FiliereMvcController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public String getAllFilieres(Model model) {
        List<FiliereDTO> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        return "responsablePedagogique/filiereList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getFiliereById(@PathVariable Long id, Model model) {
        FiliereDTO filiere = filiereService.getFiliereById(id);
        if (filiere != null) {
            model.addAttribute("filiere", filiere);
            return "responsablePedagogique/filiereDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createFiliere(@ModelAttribute FiliereDTO filiereDTO) {
        FiliereDTO createdFiliere = filiereService.createFiliere(filiereDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/filieres/" + createdFiliere.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFiliere(@PathVariable Long id, @ModelAttribute FiliereDTO filiereDTO) {
        FiliereDTO updatedFiliere = filiereService.updateFiliere(id, filiereDTO);
        if (updatedFiliere != null) {
            return ResponseEntity.ok("redirect:/filieres/" + updatedFiliere.getId());
        } else {
            // Gérer le cas où la Filiere n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filiere not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/filieres");
    }

    @GetMapping("/formation/{formationId}")
    public String getFilieresByFormationId(@PathVariable Long formationId, Model model) {
        List<FiliereDTO> filieres = filiereService.getFilieresByFormationId(formationId);
        model.addAttribute("filieres", filieres);
        return "responsablePedagogique/filiereList"; // le nom de la vue, à définir dans vos configurations
    }
}
