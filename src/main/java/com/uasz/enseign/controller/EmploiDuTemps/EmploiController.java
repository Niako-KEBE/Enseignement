package com.uasz.enseign.controller.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.EmploiDTO;
import com.uasz.enseign.services.EmploiDuTemps.EmploiService;
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
@RequestMapping("/api/emplois")
public class EmploiController {

    private final EmploiService emploiService;

    @Autowired
    public EmploiController(EmploiService emploiService) {
        this.emploiService = emploiService;
    }

    @GetMapping
    public ResponseEntity<List<EmploiDTO>> getAllEmplois() {
        List<EmploiDTO> emploiList = emploiService.getAllEmplois();
        return new ResponseEntity<>(emploiList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploiDTO> getEmploiById(@PathVariable Long id) {
        try {
            EmploiDTO emploiDTO = emploiService.getEmploiById(id);
            return new ResponseEntity<>(emploiDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmploiDTO> createEmploi(@RequestBody EmploiDTO emploiDTO) {
        EmploiDTO createdEmploi = emploiService.createEmploi(emploiDTO);
        return new ResponseEntity<>(createdEmploi, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploiDTO> updateEmploi(@PathVariable Long id, @RequestBody EmploiDTO emploiDTO) {
        try {
            EmploiDTO updatedEmploi = emploiService.updateEmploi(id, emploiDTO);
            return new ResponseEntity<>(updatedEmploi, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploi(@PathVariable Long id) {
        try {
            emploiService.deleteEmploi(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
