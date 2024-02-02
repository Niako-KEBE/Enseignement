package com.uasz.enseign.controller.Maquette;
import com.uasz.enseign.dto.Maquette.FiliereDTO;
import com.uasz.enseign.services.Maquette.FiliereService;
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
@RequestMapping("/api/filiere")
public class FiliereController {

    private final FiliereService filiereService;

    @Autowired
    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public ResponseEntity<List<FiliereDTO>> getAllFilieres() {
        List<FiliereDTO> filieres = filiereService.getAllFilieres();
        return ResponseEntity.ok(filieres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiliereDTO> getFiliereById(@PathVariable Long id) {
        FiliereDTO filiere = filiereService.getFiliereById(id);
        return ResponseEntity.of(Optional.ofNullable(filiere));
    }

    @PostMapping
    public ResponseEntity<FiliereDTO> createFiliere(@RequestBody FiliereDTO filiereDTO) {
        FiliereDTO createdFiliere = filiereService.createFiliere(filiereDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFiliere);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> updateFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        FiliereDTO updatedFiliere = filiereService.updateFiliere(id, filiereDTO);
        if (updatedFiliere != null) {
            return ResponseEntity.ok(updatedFiliere);
        } else {
            // Handle non-existing Filiere
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/formation/{formationId}")
    public ResponseEntity<List<FiliereDTO>> getFilieresByFormationId(@PathVariable Long formationId) {
        List<FiliereDTO> filieres = filiereService.getFilieresByFormationId(formationId);
        return ResponseEntity.ok(filieres);
    }
}
