package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.SemestreDTO;
import com.uasz.enseign.services.Maquette.SemestreService;
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
@RequestMapping("/semestres")
public class SemestreMvcController {

    private final SemestreService semestreService;

    @Autowired
    public SemestreMvcController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping
    public String getAllSemestres(Model model) {
        List<SemestreDTO> semestres = semestreService.getAllSemestres();
        model.addAttribute("semestres", semestres);
        return "responsablePedagogique/semestreList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getSemestreById(@PathVariable Long id, Model model) {
        SemestreDTO semestre = semestreService.getSemestreById(id);
        if (semestre != null) {
            model.addAttribute("semestre", semestre);
            return "responsablePedagogique/semestreDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createSemestre(@ModelAttribute @Validated SemestreDTO semestreDTO) {
        SemestreDTO createdSemestre = semestreService.createSemestre(semestreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/semestres/" + createdSemestre.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSemestre(@PathVariable Long id, @ModelAttribute @Validated SemestreDTO semestreDTO) {
        SemestreDTO updatedSemestre = semestreService.updateSemestre(id, semestreDTO);
        if (updatedSemestre != null) {
            return ResponseEntity.ok("redirect:/semestres/" + updatedSemestre.getId());
        } else {
            // Gérer le cas où le Semestre n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Semestre not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/semestres");
    }

    @GetMapping("/classe/{classeId}")
    public String getSemestresByClasseId(@PathVariable Long classeId, Model model) {
        List<SemestreDTO> semestres = semestreService.getSemestresByClasseId(classeId);
        model.addAttribute("semestres", semestres);
        return "responsablePedagogique/semestreList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/module/{moduleId}")
    public String getSemestresByModuleId(@PathVariable Long moduleId, Model model) {
        List<SemestreDTO> semestres = semestreService.getSemestresByModuleId(moduleId);
        model.addAttribute("semestres", semestres);
        return "responsablePedagogique/semestreList"; // le nom de la vue, à définir dans vos configurations
    }
}
