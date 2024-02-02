package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.UEDTO;
import com.uasz.enseign.services.Maquette.UEService;
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
@RequestMapping("/api/ue")
public class UEController {

    private final UEService ueService;

    @Autowired
    public UEController(UEService ueService) {
        this.ueService = ueService;
    }

    @GetMapping
    public ResponseEntity<List<UEDTO>> getAllUEs() {
        List<UEDTO> ues = ueService.getAllUEs();
        return ResponseEntity.ok(ues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UEDTO> getUEById(@PathVariable Long id) {
        UEDTO ue = ueService.getUEById(id);
        return ResponseEntity.of(Optional.ofNullable(ue));
    }

    @PostMapping
    public ResponseEntity<UEDTO> createUE(@RequestBody UEDTO ueDTO) {
        UEDTO createdUE = ueService.createUE(ueDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UEDTO> updateUE(@PathVariable Long id, @RequestBody UEDTO ueDTO) {
        UEDTO updatedUE = ueService.updateUE(id, ueDTO);
        if (updatedUE != null) {
            return ResponseEntity.ok(updatedUE);
        } else {
            // Handle non-existing UE
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUE(@PathVariable Long id) {
        ueService.deleteUE(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<UEDTO>> getUEsByUtilisateurId(@PathVariable Long utilisateurId) {
        List<UEDTO> ues = ueService.getUEsByUtilisateurId(utilisateurId);
        return ResponseEntity.ok(ues);
    }

}
