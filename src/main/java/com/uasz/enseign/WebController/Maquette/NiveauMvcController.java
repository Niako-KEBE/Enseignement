package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.NiveauDTO;
import com.uasz.enseign.services.Maquette.NiveauService;
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
@RequestMapping("/niveaux")
public class NiveauMvcController {

    private final NiveauService niveauService;

    @Autowired
    public NiveauMvcController(NiveauService niveauService) {
        this.niveauService = niveauService;
    }

    @GetMapping
    public String getAllNiveaux(Model model) {
        List<NiveauDTO> niveaux = niveauService.getAllNiveaux();
        model.addAttribute("niveaux", niveaux);
        return "responsablePedagogique/niveauList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getNiveauById(@PathVariable Long id, Model model) {
        NiveauDTO niveau = niveauService.getNiveauById(id);
        if (niveau != null) {
            model.addAttribute("niveau", niveau);
            return "responsablePedagogique/niveauDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createNiveau(@ModelAttribute NiveauDTO niveauDTO) {
        NiveauDTO createdNiveau = niveauService.createNiveau(niveauDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/niveaux/" + createdNiveau.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNiveau(@PathVariable Long id, @ModelAttribute NiveauDTO niveauDTO) {
        NiveauDTO updatedNiveau = niveauService.updateNiveau(id, niveauDTO);
        if (updatedNiveau != null) {
            return ResponseEntity.ok("redirect:/niveaux/" + updatedNiveau.getId());
        } else {
            // Gérer le cas où le Niveau n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Niveau not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNiveau(@PathVariable Long id) {
        niveauService.deleteNiveau(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/niveaux");
    }

    @GetMapping("/cycle/{cycleId}")
    public String getNiveauxByCycleId(@PathVariable Long cycleId, Model model) {
        List<NiveauDTO> niveaux = niveauService.getNiveauxByCycleId(cycleId);
        model.addAttribute("niveaux", niveaux);
        return "responsablePedagogique/niveauList"; // le nom de la vue, à définir dans vos configurations
    }
}
