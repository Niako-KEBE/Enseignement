package com.uasz.enseign.WebController.Maquette;
import com.uasz.enseign.dto.Maquette.ModuleDTO;
import com.uasz.enseign.services.Maquette.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@Slf4j
@Controller
@RequestMapping("/modules")
public class ModuleMvcController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleMvcController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public String getAllModules(Model model) {
        List<ModuleDTO> modules = moduleService.getAllModules();
        model.addAttribute("modules", modules);
        return "responsablePedagogique/moduleList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getModuleById(@PathVariable Long id, Model model) {
        ModuleDTO module = moduleService.getModuleById(id);
        if (module != null) {
            model.addAttribute("module", module);
            return "responsablePedagogique/moduleDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createModule(@ModelAttribute ModuleDTO moduleDTO) {
        ModuleDTO createdModule = moduleService.createModule(moduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/modules/" + createdModule.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateModule(@PathVariable Long id, @ModelAttribute ModuleDTO moduleDTO) {
        ModuleDTO updatedModule = moduleService.updateModule(id, moduleDTO);
        if (updatedModule != null) {
            return ResponseEntity.ok("redirect:/modules/" + updatedModule.getId());
        } else {
            // Gérer le cas où le Module n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/modules");
    }

    @GetMapping("/ue/{ueId}")
    public String getModulesByUeId(@PathVariable Long ueId, Model model) {
        List<ModuleDTO> modules = moduleService.getModulesByUeId(ueId);
        model.addAttribute("modules", modules);
        return "responsablePedagogique/moduleList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/ec/{ecId}")
    public String getModulesByEcId(@PathVariable Long ecId, Model model) {
        List<ModuleDTO> modules = moduleService.getModulesByEcId(ecId);
        model.addAttribute("modules", modules);
        return "responsablePedagogique/moduleList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/semestre/{semestreId}")
    public String getModulesBySemestreId(@PathVariable Long semestreId, Model model) {
        List<ModuleDTO> modules = moduleService.getModulesBySemestreId(semestreId);
        model.addAttribute("modules", modules);
        return "responsablePedagogique/moduleList"; // le nom de la vue, à définir dans vos configurations
    }
}
