package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.SemestreDTO;
import com.uasz.enseign.services.Maquette.SemestreService;
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
@RequestMapping("/api/semestre")
public class SemestreController {

    private final SemestreService semestreService;

    @Autowired
    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping
    public ResponseEntity<List<SemestreDTO>> getAllSemestres() {
        List<SemestreDTO> semestres = semestreService.getAllSemestres();
        return ResponseEntity.ok(semestres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreDTO> getSemestreById(@PathVariable Long id) {
        SemestreDTO semestre = semestreService.getSemestreById(id);
        return ResponseEntity.of(Optional.ofNullable(semestre));
    }

    @PostMapping
    public ResponseEntity<SemestreDTO> createSemestre(@RequestBody SemestreDTO semestreDTO) {
        SemestreDTO createdSemestre = semestreService.createSemestre(semestreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSemestre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemestreDTO> updateSemestre(@PathVariable Long id, @RequestBody SemestreDTO semestreDTO) {
        SemestreDTO updatedSemestre = semestreService.updateSemestre(id, semestreDTO);
        if (updatedSemestre != null) {
            return ResponseEntity.ok(updatedSemestre);
        } else {
            // Handle non-existing Semestre
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<SemestreDTO>> getSemestresByClasseId(@PathVariable Long classeId) {
        List<SemestreDTO> semestres = semestreService.getSemestresByClasseId(classeId);
        return ResponseEntity.ok(semestres);
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<SemestreDTO>> getSemestresByModuleId(@PathVariable Long moduleId) {
        List<SemestreDTO> semestres = semestreService.getSemestresByModuleId(moduleId);
        return ResponseEntity.ok(semestres);
    }

}
