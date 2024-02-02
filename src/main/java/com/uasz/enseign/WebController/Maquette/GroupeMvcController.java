package com.uasz.enseign.WebController.Maquette;
import com.uasz.enseign.dto.Maquette.GroupeDTO;
import com.uasz.enseign.services.Maquette.GroupeService;
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
@RequestMapping("/groupes")
public class GroupeMvcController {

    private final GroupeService groupeService;

    @Autowired
    public GroupeMvcController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping
    public String getAllGroupes(Model model) {
        List<GroupeDTO> groupes = groupeService.getAllGroupes();
        model.addAttribute("groupes", groupes);
        return "responsablePedagogique/groupeList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getGroupeById(@PathVariable Long id, Model model) {
        GroupeDTO groupe = groupeService.getGroupeById(id);
        if (groupe != null) {
            model.addAttribute("groupe", groupe);
            return "responsablePedagogique/groupeDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "responsablePedagogique/notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> createGroupe(@ModelAttribute GroupeDTO groupeDTO) {
        GroupeDTO createdGroupe = groupeService.createGroupe(groupeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/groupes/" + createdGroupe.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGroupe(@PathVariable Long id, @ModelAttribute GroupeDTO groupeDTO) {
        GroupeDTO updatedGroupe = groupeService.updateGroupe(id, groupeDTO);
        if (updatedGroupe != null) {
            return ResponseEntity.ok("redirect:/groupes/" + updatedGroupe.getId());
        } else {
            // Gérer le cas où le Groupe n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Groupe not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroupe(@PathVariable Long id) {
        groupeService.deleteGroupe(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/groupes");
    }

    @GetMapping("/classe/{classeId}")
    public String getGroupesByClasseId(@PathVariable Long classeId, Model model) {
        List<GroupeDTO> groupes = groupeService.getGroupesByClasseId(classeId);
        model.addAttribute("groupes", groupes);
        return "responsablePedagogique/groupeList"; // le nom de la vue, à définir dans vos configurations
    }
}
