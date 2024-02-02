package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.UEDTO;
import com.uasz.enseign.services.Maquette.UEService;
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
@RequestMapping("/ues")
public class UEMvcController {

    private final UEService ueService;

    @Autowired
    public UEMvcController(UEService ueService) {
        this.ueService = ueService;
    }

    @GetMapping
    public String getAllUEs(Model model) {
        List<UEDTO> ues = ueService.getAllUEs();
        model.addAttribute("ues", ues);
        return "responsablePedagogique/ueList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getUEById(@PathVariable Long id, Model model) {
        UEDTO ue = ueService.getUEById(id);
        if (ue != null) {
            model.addAttribute("ue", ue);
            return "responsablePedagogique/ueDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createUE(@ModelAttribute @Validated UEDTO ueDTO) {
        UEDTO createdUE = ueService.createUE(ueDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/ues/" + createdUE.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUE(@PathVariable Long id, @ModelAttribute @Validated UEDTO ueDTO) {
        UEDTO updatedUE = ueService.updateUE(id, ueDTO);
        if (updatedUE != null) {
            return ResponseEntity.ok("redirect:/ues/" + updatedUE.getId());
        } else {
            // Gérer le cas où l'UE n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UE not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUE(@PathVariable Long id) {
        ueService.deleteUE(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/ues");
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public String getUEsByUtilisateurId(@PathVariable Long utilisateurId, Model model) {
        List<UEDTO> ues = ueService.getUEsByUtilisateurId(utilisateurId);
        model.addAttribute("ues", ues);
        return "responsablePedagogique/ueList"; // le nom de la vue, à définir dans vos configurations
    }
}
