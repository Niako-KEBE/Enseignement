package com.uasz.enseign.controller.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.DeroulementDTO;
import com.uasz.enseign.services.EmploiDuTemps.DeroulementService;
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
@RequestMapping("/api/deroulements")
public class DeroulementController {

    private final DeroulementService deroulementService;

    @Autowired
    public DeroulementController(DeroulementService deroulementService) {
        this.deroulementService = deroulementService;
    }

    @GetMapping
    public ResponseEntity<List<DeroulementDTO>> getAllDeroulements() {
        List<DeroulementDTO> deroulementList = deroulementService.getAllDeroulements();
        return new ResponseEntity<>(deroulementList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeroulementDTO> getDeroulementById(@PathVariable Long id) {
        DeroulementDTO deroulementDTO = deroulementService.getDeroulementById(id);
        return (deroulementDTO != null)
                ? new ResponseEntity<>(deroulementDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DeroulementDTO> createDeroulement(@RequestBody DeroulementDTO deroulementDTO) {
        DeroulementDTO createdDeroulement = deroulementService.createDeroulement(deroulementDTO);
        return new ResponseEntity<>(createdDeroulement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeroulementDTO> updateDeroulement(@PathVariable Long id, @RequestBody DeroulementDTO deroulementDTO) {
        DeroulementDTO updatedDeroulement = deroulementService.updateDeroulement(id, deroulementDTO);
        return (updatedDeroulement != null)
                ? new ResponseEntity<>(updatedDeroulement, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeroulement(@PathVariable Long id) {
        deroulementService.deleteDeroulement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
