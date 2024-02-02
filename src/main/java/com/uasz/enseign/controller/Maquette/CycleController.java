package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.CycleDTO;
import com.uasz.enseign.services.Maquette.CycleService;
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
@RequestMapping("/api/cycles")
public class CycleController {

    private final CycleService cycleService;

    @Autowired
    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @GetMapping
    public ResponseEntity<List<CycleDTO>> getAllCycles() {
        List<CycleDTO> cycles = cycleService.getAllCycles();
        return ResponseEntity.ok(cycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CycleDTO> getCycleById(@PathVariable Long id) {
        CycleDTO cycle = cycleService.getCycleById(id);
        return ResponseEntity.of(Optional.ofNullable(cycle));
    }

    @PostMapping
    public ResponseEntity<CycleDTO> createCycle(@RequestBody CycleDTO cycleDTO) {
        CycleDTO createdCycle = cycleService.createCycle(cycleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCycle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CycleDTO> updateCycle(@PathVariable Long id, @RequestBody CycleDTO cycleDTO) {
        CycleDTO updatedCycle = cycleService.updateCycle(id, cycleDTO);
        if (updatedCycle != null) {
            return ResponseEntity.ok(updatedCycle);
        } else {
            // Handle non-existing cycle
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCycle(@PathVariable Long id) {
        cycleService.deleteCycle(id);
        return ResponseEntity.noContent().build();
    }
}
