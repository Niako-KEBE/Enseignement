package com.uasz.enseign.controller.Maquette;


import com.uasz.enseign.dto.Maquette.ModuleDTO;
import com.uasz.enseign.services.Maquette.ModuleService;
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
@RequestMapping("/api/module")
public class ModuleController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> getAllModules() {
        List<ModuleDTO> modules = moduleService.getAllModules();
        return ResponseEntity.ok(modules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModuleById(@PathVariable Long id) {
        ModuleDTO module = moduleService.getModuleById(id);
        return ResponseEntity.of(Optional.ofNullable(module));
    }

    @PostMapping
    public ResponseEntity<ModuleDTO> createModule(@RequestBody ModuleDTO moduleDTO) {
        ModuleDTO createdModule = moduleService.createModule(moduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleDTO> updateModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {
        ModuleDTO updatedModule = moduleService.updateModule(id, moduleDTO);
        if (updatedModule != null) {
            return ResponseEntity.ok(updatedModule);
        } else {
            // Handle non-existing Module
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ue/{ueId}")
    public ResponseEntity<List<ModuleDTO>> getModulesByUeId(@PathVariable Long ueId) {
        List<ModuleDTO> modules = moduleService.getModulesByUeId(ueId);
        return ResponseEntity.ok(modules);
    }

    @GetMapping("/ec/{ecId}")
    public ResponseEntity<List<ModuleDTO>> getModulesByEcId(@PathVariable Long ecId) {
        List<ModuleDTO> modules = moduleService.getModulesByEcId(ecId);
        return ResponseEntity.ok(modules);
    }

    @GetMapping("/semestre/{semestreId}")
    public ResponseEntity<List<ModuleDTO>> getModulesBySemestreId(@PathVariable Long semestreId) {
        List<ModuleDTO> modules = moduleService.getModulesBySemestreId(semestreId);
        return ResponseEntity.ok(modules);
    }
}
