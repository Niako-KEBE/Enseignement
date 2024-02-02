package com.uasz.enseign.controller.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.services.Repartition.EnseignantService;
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
@RequestMapping("/api/enseignants")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public ResponseEntity<List<EnseignantDTO>> getAllEnseignants() {
        List<EnseignantDTO> enseignants = enseignantService.getAllEnseignants();
        return ResponseEntity.ok(enseignants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantDTO> getEnseignantById(@PathVariable Long id) {
        EnseignantDTO enseignant = enseignantService.getEnseignantById(id);
        return ResponseEntity.of(Optional.ofNullable(enseignant));
    }

    @PostMapping
    public ResponseEntity<EnseignantDTO> createEnseignant(@RequestBody EnseignantDTO enseignantDTO) {
        EnseignantDTO createdEnseignant = enseignantService.createEnseignant(enseignantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnseignant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnseignantDTO> updateEnseignant(@PathVariable Long id, @RequestBody EnseignantDTO enseignantDTO) {
        EnseignantDTO updatedEnseignant = enseignantService.updateEnseignant(id, enseignantDTO);
        if (updatedEnseignant != null) {
            return ResponseEntity.ok(updatedEnseignant);
        } else {
            // Handle non-existing Enseignant
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.noContent().build();
    }

}
