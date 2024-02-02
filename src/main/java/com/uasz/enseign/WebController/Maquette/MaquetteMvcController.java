package com.uasz.enseign.WebController.Maquette;
import com.uasz.enseign.dto.Maquette.MaquetteDTO;
import com.uasz.enseign.services.Maquette.MaquetteService;
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
@RequestMapping("/maquettes")
public class MaquetteMvcController {

    private final MaquetteService maquetteService;

    @Autowired
    public MaquetteMvcController(MaquetteService maquetteService) {
        this.maquetteService = maquetteService;
    }

    @GetMapping
    public String getAllMaquettes(Model model) {
        List<MaquetteDTO> maquettes = maquetteService.getAllMaquettes();
        model.addAttribute("maquettes", maquettes);
        return "responsablePedagogique/maquetteList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getMaquetteById(@PathVariable Long id, Model model) {
        MaquetteDTO maquette = maquetteService.getMaquetteById(id);
        if (maquette != null) {
            model.addAttribute("maquette", maquette);
            return "responsablePedagogique/maquetteDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createMaquette(@ModelAttribute MaquetteDTO maquetteDTO) {
        MaquetteDTO createdMaquette = maquetteService.createMaquette(maquetteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/maquettes/" + createdMaquette.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMaquette(@PathVariable Long id, @ModelAttribute MaquetteDTO maquetteDTO) {
        MaquetteDTO updatedMaquette = maquetteService.updateMaquette(id, maquetteDTO);
        if (updatedMaquette != null) {
            return ResponseEntity.ok("redirect:/maquettes/" + updatedMaquette.getId());
        } else {
            // Gérer le cas où la Maquette n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Maquette not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaquette(@PathVariable Long id) {
        maquetteService.deleteMaquette(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/maquettes");
    }

    @GetMapping("/formation/{formationId}")
    public String getMaquettesByFormationId(@PathVariable Long formationId, Model model) {
        List<MaquetteDTO> maquettes = maquetteService.getMaquettesByFormationId(formationId);
        model.addAttribute("maquettes", maquettes);
        return "responsablePedagogique/maquetteList"; // le nom de la vue, à définir dans vos configurations
    }
}
