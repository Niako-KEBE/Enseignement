package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.EnseignementDTO;
import com.uasz.enseign.services.Maquette.EnseignementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/enseignements")
public class EnseignementController {

    private final EnseignementService enseignementService;

    @Autowired
    public EnseignementController(EnseignementService enseignementService) {
        this.enseignementService = enseignementService;
    }

    @GetMapping
    public ResponseEntity<List<EnseignementDTO>> getAllEnseignements() {
        List<EnseignementDTO> enseignements = enseignementService.getAllEnseignements();
        return ResponseEntity.ok(enseignements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignementDTO> getEnseignementById(@PathVariable Long id) {
        EnseignementDTO enseignement = enseignementService.getEnseignementById(id);
        return ResponseEntity.of(Optional.ofNullable(enseignement));
    }

    @PostMapping
    public ResponseEntity<EnseignementDTO> createEnseignement(@RequestBody EnseignementDTO enseignementDTO) {
        EnseignementDTO createdEnseignement = enseignementService.createEnseignement(enseignementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnseignement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnseignementDTO> updateEnseignement(@PathVariable Long id, @RequestBody EnseignementDTO enseignementDTO) {
        EnseignementDTO updatedEnseignement = enseignementService.updateEnseignement(id, enseignementDTO);
        if (updatedEnseignement != null) {
            return ResponseEntity.ok(updatedEnseignement);
        } else {
            // Handle non-existing Enseignement
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignement(@PathVariable Long id) {
        enseignementService.deleteEnseignement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<EnseignementDTO>> getEnseignementsByClasseId(@PathVariable Long classeId) {
        List<EnseignementDTO> enseignements = enseignementService.getEnseignementsByClasseId(classeId);
        return ResponseEntity.ok(enseignements);
    }

    @GetMapping("/groupe/{groupeId}")
    public ResponseEntity<List<EnseignementDTO>> getEnseignementsByGroupeId(@PathVariable Long groupeId) {
        List<EnseignementDTO> enseignements = enseignementService.getEnseignementsByGroupeId(groupeId);
        return ResponseEntity.ok(enseignements);
    }

}
