package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.CycleDTO;
import com.uasz.enseign.services.Maquette.CycleService;
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
@RequestMapping("/cycles")
public class CycleController {

    private final CycleService cycleService;

    @Autowired
    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @GetMapping
    public String getAllCycles(Model model) {
        List<CycleDTO> cycles = cycleService.getAllCycles();
        model.addAttribute("cycles", cycles);
        return "responsablePedagogique/cycleList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getCycleById(@PathVariable Long id, Model model) {
        CycleDTO cycle = cycleService.getCycleById(id);
        if (cycle != null) {
            model.addAttribute("cycle", cycle);
            return "responsablePedagogique/cycleDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createCycle(@ModelAttribute CycleDTO cycleDTO) {
        CycleDTO createdCycle = cycleService.createCycle(cycleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/cycles/" + createdCycle.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCycle(@PathVariable Long id, @ModelAttribute CycleDTO cycleDTO) {
        CycleDTO updatedCycle = cycleService.updateCycle(id, cycleDTO);
        if (updatedCycle != null) {
            return ResponseEntity.ok("redirect:/cycles/" + updatedCycle.getId());
        } else {
            // Gérer le cas où le cycle n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cycle not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCycle(@PathVariable Long id) {
        cycleService.deleteCycle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/cycles");
    }
}
