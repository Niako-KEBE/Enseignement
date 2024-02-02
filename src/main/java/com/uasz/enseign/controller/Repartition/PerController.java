package com.uasz.enseign.controller.Repartition;

import com.uasz.enseign.dto.Repartition.PERDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.uasz.enseign.services.Repartition.PERService;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/repartition/per")
public class PERController {

    private final PERService perService;

    @Autowired
    public PERController(PERService perService) {
        this.perService = perService;
    }

    @GetMapping
    public ResponseEntity<List<PERDTO>> getAllPERs() {
        List<PERDTO> perList = perService.getAllPERs();
        return new ResponseEntity<>(perList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PERDTO> getPERById(@PathVariable Long id) {
        PERDTO perDTO = perService.getPERById(id);
        return (perDTO != null)
                ? new ResponseEntity<>(perDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PERDTO> createPER(@RequestBody PERDTO perDTO) {
        PERDTO createdPER = perService.createPER(perDTO);
        return new ResponseEntity<>(createdPER, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PERDTO> updatePER(@PathVariable Long id, @RequestBody PERDTO perDTO) {
        PERDTO updatedPER = perService.updatePER(id, perDTO);
        return (updatedPER != null)
                ? new ResponseEntity<>(updatedPER, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePER(@PathVariable Long id) {
        perService.deletePER(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
