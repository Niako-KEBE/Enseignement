package com.uasz.enseign.controller.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SalleDTO;
import com.uasz.enseign.services.EmploiDuTemps.SalleService;
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
@RequestMapping("/api/salles")
public class SalleController {

    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public ResponseEntity<List<SalleDTO>> getAllSalles() {
        List<SalleDTO> salleList = salleService.getAllSalles();
        return new ResponseEntity<>(salleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleDTO> getSalleById(@PathVariable Long id) {
        SalleDTO salleDTO = salleService.getSalleById(id);
        if (salleDTO != null) {
            return new ResponseEntity<>(salleDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SalleDTO> createSalle(@RequestBody SalleDTO salleDTO) {
        SalleDTO createdSalle = salleService.createSalle(salleDTO);
        return new ResponseEntity<>(createdSalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalleDTO> updateSalle(@PathVariable Long id, @RequestBody SalleDTO salleDTO) {
        SalleDTO updatedSalle = salleService.updateSalle(id, salleDTO);
        if (updatedSalle != null) {
            return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
