package com.uasz.enseign.WebController.Maquette;
import com.uasz.enseign.dto.Maquette.ECDTO;
import com.uasz.enseign.services.Maquette.ECService;
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
@RequestMapping("/ecs")
public class ECMvcController {

    private final ECService ecService;

    @Autowired
    public ECMvcController(ECService ecService) {
        this.ecService = ecService;
    }

    @GetMapping
    public String getAllECs(Model model) {
        List<ECDTO> ecs = ecService.getAllECs();
        model.addAttribute("ecs", ecs);
        return "responsablePedagogique/ecList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getECById(@PathVariable Long id, Model model) {
        ECDTO ec = ecService.getECById(id);
        if (ec != null) {
            model.addAttribute("ec", ec);
            return "responsablePedagogique/ecDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createEC(@ModelAttribute ECDTO ecDTO) {
        ECDTO createdEC = ecService.createEC(ecDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/ecs/" + createdEC.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEC(@PathVariable Long id, @ModelAttribute ECDTO ecDTO) {
        ECDTO updatedEC = ecService.updateEC(id, ecDTO);
        if (updatedEC != null) {
            return ResponseEntity.ok("redirect:/ecs/" + updatedEC.getId());
        } else {
            // Gérer le cas où l'EC n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EC not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEC(@PathVariable Long id) {
        ecService.deleteEC(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/ecs");
    }

    @GetMapping("/ue/{ueId}")
    public String getECsByUeId(@PathVariable Long ueId, Model model) {
        List<ECDTO> ecs = ecService.getECsByUeId(ueId);
        model.addAttribute("ecs", ecs);
        return "responsablePedagogique/ecList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/module/{moduleId}")
    public String getECsByModuleId(@PathVariable Long moduleId, Model model) {
        List<ECDTO> ecs = ecService.getECsByModuleId(moduleId);
        model.addAttribute("ecs", ecs);
        return "responsablePedagogique/ecList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/semestre/{semestreId}")
    public String getECsBySemestreId(@PathVariable Long semestreId, Model model) {
        List<ECDTO> ecs = ecService.getECsBySemestreId(semestreId);
        model.addAttribute("ecs", ecs);
        return "responsablePedagogique/ecList"; // le nom de la vue, à définir dans vos configurations
    }
}
