package com.uasz.enseign.controller.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import com.uasz.enseign.services.EmploiDuTemps.SeanceService;
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
@RequestMapping("/api/seances")
public class SeanceController {

    private final SeanceService seanceService;

    @Autowired
    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public ResponseEntity<List<SeanceDTO>> getAllSeances() {
        List<SeanceDTO> seanceList = seanceService.getAllSeances();
        return new ResponseEntity<>(seanceList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeanceDTO> getSeanceById(@PathVariable Long id) {
        SeanceDTO seanceDTO = seanceService.getSeanceById(id);
        if (seanceDTO != null) {
            return new ResponseEntity<>(seanceDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SeanceDTO> createSeance(@RequestBody SeanceDTO seanceDTO) {
        SeanceDTO createdSeance = seanceService.createSeance(seanceDTO);
        return new ResponseEntity<>(createdSeance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeanceDTO> updateSeance(@PathVariable Long id, @RequestBody SeanceDTO seanceDTO) {
        SeanceDTO updatedSeance = seanceService.updateSeance(id, seanceDTO);
        if (updatedSeance != null) {
            return new ResponseEntity<>(updatedSeance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
