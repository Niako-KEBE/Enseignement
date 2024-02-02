package com.uasz.enseign.controller.Maquette;
import com.uasz.enseign.dto.Maquette.MaquetteDTO;
import com.uasz.enseign.services.Maquette.MaquetteService;
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
@RequestMapping("/api/maquette")
public class MaquetteController {

    private final MaquetteService maquetteService;

    @Autowired
    public MaquetteController(MaquetteService maquetteService) {
        this.maquetteService = maquetteService;
    }

    @GetMapping
    public ResponseEntity<List<MaquetteDTO>> getAllMaquettes() {
        List<MaquetteDTO> maquettes = maquetteService.getAllMaquettes();
        return ResponseEntity.ok(maquettes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaquetteDTO> getMaquetteById(@PathVariable Long id) {
        MaquetteDTO maquette = maquetteService.getMaquetteById(id);
        return ResponseEntity.of(Optional.ofNullable(maquette));
    }

    @PostMapping
    public ResponseEntity<MaquetteDTO> createMaquette(@RequestBody MaquetteDTO maquetteDTO) {
        MaquetteDTO createdMaquette = maquetteService.createMaquette(maquetteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMaquette);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaquetteDTO> updateMaquette(@PathVariable Long id, @RequestBody MaquetteDTO maquetteDTO) {
        MaquetteDTO updatedMaquette = maquetteService.updateMaquette(id, maquetteDTO);
        if (updatedMaquette != null) {
            return ResponseEntity.ok(updatedMaquette);
        } else {
            // Handle non-existing Maquette
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaquette(@PathVariable Long id) {
        maquetteService.deleteMaquette(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/formation/{formationId}")
    public ResponseEntity<List<MaquetteDTO>> getMaquettesByFormationId(@PathVariable Long formationId) {
        List<MaquetteDTO> maquettes = maquetteService.getMaquettesByFormationId(formationId);
        return ResponseEntity.ok(maquettes);
    }
}
