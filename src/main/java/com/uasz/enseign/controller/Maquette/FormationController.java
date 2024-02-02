package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.FormationDTO;
import com.uasz.enseign.services.Maquette.FormationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/formation")
public class FormationController {

    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        List<FormationDTO> formations = formationService.getAllFormations();
        return ResponseEntity.ok(formations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long id) {
        FormationDTO formation = formationService.getFormationById(id);
        return ResponseEntity.of(Optional.ofNullable(formation));
    }

    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        FormationDTO createdFormation = formationService.createFormation(formationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Long id, @RequestBody FormationDTO formationDTO) {
        FormationDTO updatedFormation = formationService.updateFormation(id, formationDTO);
        if (updatedFormation != null) {
            return ResponseEntity.ok(updatedFormation);
        } else {
            // Handle non-existing Formation
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filiere/{filiereId}")
    public ResponseEntity<List<FormationDTO>> getFormationsByFiliereId(@PathVariable Long filiereId) {
        List<FormationDTO> formations = formationService.getFormationsByFiliereId(filiereId);
        return ResponseEntity.ok(formations);
    }

    @GetMapping("/niveau/{niveauId}")
    public ResponseEntity<List<FormationDTO>> getFormationsByNiveauId(@PathVariable Long niveauId) {
        List<FormationDTO> formations = formationService.getFormationsByNiveauId(niveauId);
        return ResponseEntity.ok(formations);
    }
}
