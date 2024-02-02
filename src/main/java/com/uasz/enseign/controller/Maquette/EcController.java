package com.uasz.enseign.controller.Maquette;
import com.uasz.enseign.dto.Maquette.ECDTO;
import com.uasz.enseign.services.Maquette.ECService;
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
@RequestMapping("/api/ec")
public class ECController {

    private final ECService ecService;

    @Autowired
    public ECController(ECService ecService) {
        this.ecService = ecService;
    }

    @GetMapping
    public ResponseEntity<List<ECDTO>> getAllECs() {
        List<ECDTO> ecs = ecService.getAllECs();
        return ResponseEntity.ok(ecs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ECDTO> getECById(@PathVariable Long id) {
        ECDTO ec = ecService.getECById(id);
        return ResponseEntity.of(Optional.ofNullable(ec));
    }

    @PostMapping
    public ResponseEntity<ECDTO> createEC(@RequestBody ECDTO ecDTO) {
        ECDTO createdEC = ecService.createEC(ecDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEC);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ECDTO> updateEC(@PathVariable Long id, @RequestBody ECDTO ecDTO) {
        ECDTO updatedEC = ecService.updateEC(id, ecDTO);
        if (updatedEC != null) {
            return ResponseEntity.ok(updatedEC);
        } else {
            // Handle non-existing EC
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEC(@PathVariable Long id) {
        ecService.deleteEC(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ue/{ueId}")
    public ResponseEntity<List<ECDTO>> getECsByUeId(@PathVariable Long ueId) {
        List<ECDTO> ecs = ecService.getECsByUeId(ueId);
        return ResponseEntity.ok(ecs);
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ECDTO>> getECsByModuleId(@PathVariable Long moduleId) {
        List<ECDTO> ecs = ecService.getECsByModuleId(moduleId);
        return ResponseEntity.ok(ecs);
    }

    @GetMapping("/semestre/{semestreId}")
    public ResponseEntity<List<ECDTO>> getECsBySemestreId(@PathVariable Long semestreId) {
        List<ECDTO> ecs = ecService.getECsBySemestreId(semestreId);
        return ResponseEntity.ok(ecs);
    }
}
