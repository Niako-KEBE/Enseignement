package com.uasz.enseign.controller.Maquette;


import com.uasz.enseign.dto.Maquette.NiveauDTO;
import com.uasz.enseign.services.Maquette.NiveauService;
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
@RequestMapping("/api/niveau")
public class NiveauController {

    private final NiveauService niveauService;

    @Autowired
    public NiveauController(NiveauService niveauService) {
        this.niveauService = niveauService;
    }

    @GetMapping
    public ResponseEntity<List<NiveauDTO>> getAllNiveaux() {
        List<NiveauDTO> niveaux = niveauService.getAllNiveaux();
        return ResponseEntity.ok(niveaux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NiveauDTO> getNiveauById(@PathVariable Long id) {
        NiveauDTO niveau = niveauService.getNiveauById(id);
        return ResponseEntity.of(Optional.ofNullable(niveau));
    }

    @PostMapping
    public ResponseEntity<NiveauDTO> createNiveau(@RequestBody NiveauDTO niveauDTO) {
        NiveauDTO createdNiveau = niveauService.createNiveau(niveauDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNiveau);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NiveauDTO> updateNiveau(@PathVariable Long id, @RequestBody NiveauDTO niveauDTO) {
        NiveauDTO updatedNiveau = niveauService.updateNiveau(id, niveauDTO);
        if (updatedNiveau != null) {
            return ResponseEntity.ok(updatedNiveau);
        } else {
            // Handle non-existing Niveau
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNiveau(@PathVariable Long id) {
        niveauService.deleteNiveau(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cycle/{cycleId}")
    public ResponseEntity<List<NiveauDTO>> getNiveauxByCycleId(@PathVariable Long cycleId) {
        List<NiveauDTO> niveaux = niveauService.getNiveauxByCycleId(cycleId);
        return ResponseEntity.ok(niveaux);
    }

    // Vous pouvez ajouter d'autres méthodes de contrôleur en fonction de vos besoins spécifiques
}
