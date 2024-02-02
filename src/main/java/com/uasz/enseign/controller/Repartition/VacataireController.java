package com.uasz.enseign.controller.Repartition;

import com.uasz.enseign.dto.Repartition.VacataireDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.uasz.enseign.services.Repartition.VacataireService;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/vacataires")
public class VacataireController {

    private final VacataireService vacataireService;

    @Autowired
    public VacataireController(VacataireService vacataireService) {
        this.vacataireService = vacataireService;
    }

    @GetMapping
    public ResponseEntity<List<VacataireDTO>> getAllVacataires() {
        List<VacataireDTO> vacataireList = vacataireService.getAllVacataires();
        return new ResponseEntity<>(vacataireList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacataireDTO> getVacataireById(@PathVariable Long id) {
        VacataireDTO vacataireDTO = vacataireService.getVacataireById(id);
        return (vacataireDTO != null)
                ? new ResponseEntity<>(vacataireDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VacataireDTO> createVacataire(@RequestBody VacataireDTO vacataireDTO) {
        VacataireDTO createdVacataire = vacataireService.createVacataire(vacataireDTO);
        return new ResponseEntity<>(createdVacataire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacataireDTO> updateVacataire(@PathVariable Long id, @RequestBody VacataireDTO vacataireDTO) {
        VacataireDTO updatedVacataire = vacataireService.updateVacataire(id, vacataireDTO);
        return (updatedVacataire != null)
                ? new ResponseEntity<>(updatedVacataire, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacataire(@PathVariable Long id) {
        vacataireService.deleteVacataire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
