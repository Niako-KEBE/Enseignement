package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import com.uasz.enseign.services.Maquette.ClasseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    private final ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> getAllClasses() {
        List<ClasseDTO> classes = classeService.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> getClasseById(@PathVariable Long id) {
        ClasseDTO classe = classeService.getClasseById(id);
        return classe != null
                ? new ResponseEntity<>(classe, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ClasseDTO> createClasse(@RequestBody ClasseDTO classeDTO) {
        ClasseDTO createdClasse = classeService.createClasse(classeDTO);
        return new ResponseEntity<>(createdClasse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseDTO> updateClasse(@PathVariable Long id, @RequestBody ClasseDTO classeDTO) {
        ClasseDTO updatedClasse = classeService.updateClasse(id, classeDTO);
        return updatedClasse != null
                ? new ResponseEntity<>(updatedClasse, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/bySemestre/{semestreId}")
    public ResponseEntity<List<ClasseDTO>> getClassesBySemestreId(@PathVariable Long semestreId) {
        List<ClasseDTO> classes = classeService.getClassesBySemestreId(semestreId);
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/byFormation/{formationId}")
    public ResponseEntity<List<ClasseDTO>> getClassesByFormationId(@PathVariable Long formationId) {
        List<ClasseDTO> classes = classeService.getClassesByFormationId(formationId);
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/byEnseignement/{enseignementId}")
    public ResponseEntity<List<ClasseDTO>> getClassesByEnseignementId(@PathVariable Long enseignementId) {
        List<ClasseDTO> classes = classeService.getClassesByEnseignementId(enseignementId);
        return ResponseEntity.ok(classes);
    }
}
