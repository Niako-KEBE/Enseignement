package com.uasz.enseign.controller.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import com.uasz.enseign.services.EmploiDuTemps.BatimentService;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/batiments")
public class BatimentController {

    private final BatimentService batimentService;

    @Autowired
    public BatimentController(BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    @GetMapping
    public ResponseEntity<List<BatimentDTO>> getAllBatiments() {
        List<BatimentDTO> batimentList = batimentService.getAllBatiments();
        return new ResponseEntity<>(batimentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatimentDTO> getBatimentById(@PathVariable Long id) {
        BatimentDTO batimentDTO = batimentService.getBatimentById(id);
        return (batimentDTO != null)
                ? new ResponseEntity<>(batimentDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO batimentDTO) {
        BatimentDTO createdBatiment = batimentService.createBatiment(batimentDTO);
        return new ResponseEntity<>(createdBatiment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatimentDTO> updateBatiment(@PathVariable Long id, @RequestBody BatimentDTO batimentDTO) {
        BatimentDTO updatedBatiment = batimentService.updateBatiment(id, batimentDTO);
        return (updatedBatiment != null)
                ? new ResponseEntity<>(updatedBatiment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatiment(@PathVariable Long id) {
        batimentService.deleteBatiment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
