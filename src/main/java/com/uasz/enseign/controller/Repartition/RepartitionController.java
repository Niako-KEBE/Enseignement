package com.uasz.enseign.controller.Repartition;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;
import com.uasz.enseign.services.Repartition.RepartitionService;
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
@RequestMapping("/api/repartition")
public class RepartitionController {

    private final RepartitionService repartitionService;

    @Autowired
    public RepartitionController(RepartitionService repartitionService) {
        this.repartitionService = repartitionService;
    }

    @GetMapping
    public ResponseEntity<List<RepartitionDTO>> getAllRepartitions() {
        List<RepartitionDTO> repartitionList = repartitionService.getAllRepartitions();
        return new ResponseEntity<>(repartitionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepartitionDTO> getRepartitionById(@PathVariable Long id) {
        RepartitionDTO repartitionDTO = repartitionService.getRepartitionById(id);
        return (repartitionDTO != null)
                ? new ResponseEntity<>(repartitionDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RepartitionDTO> createRepartition(@RequestBody RepartitionDTO repartitionDTO) {
        RepartitionDTO createdRepartition = repartitionService.createRepartition(repartitionDTO);
        return new ResponseEntity<>(createdRepartition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepartitionDTO> updateRepartition(@PathVariable Long id, @RequestBody RepartitionDTO repartitionDTO) {
        RepartitionDTO updatedRepartition = repartitionService.updateRepartition(id, repartitionDTO);
        return (updatedRepartition != null)
                ? new ResponseEntity<>(updatedRepartition, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepartition(@PathVariable Long id) {
        repartitionService.deleteRepartition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
