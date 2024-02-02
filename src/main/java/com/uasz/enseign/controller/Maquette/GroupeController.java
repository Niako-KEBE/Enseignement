package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.GroupeDTO;
import com.uasz.enseign.services.Maquette.GroupeService;
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
@RequestMapping("/api/groupe")
public class GroupeController {

    private final GroupeService groupeService;

    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping
    public ResponseEntity<List<GroupeDTO>> getAllGroupes() {
        List<GroupeDTO> groupes = groupeService.getAllGroupes();
        return ResponseEntity.ok(groupes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupeDTO> getGroupeById(@PathVariable Long id) {
        GroupeDTO groupe = groupeService.getGroupeById(id);
        return ResponseEntity.of(Optional.ofNullable(groupe));
    }

    @PostMapping
    public ResponseEntity<GroupeDTO> createGroupe(@RequestBody GroupeDTO groupeDTO) {
        GroupeDTO createdGroupe = groupeService.createGroupe(groupeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGroupe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupeDTO> updateGroupe(@PathVariable Long id, @RequestBody GroupeDTO groupeDTO) {
        GroupeDTO updatedGroupe = groupeService.updateGroupe(id, groupeDTO);
        if (updatedGroupe != null) {
            return ResponseEntity.ok(updatedGroupe);
        } else {
            // Handle non-existing Groupe
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupe(@PathVariable Long id) {
        groupeService.deleteGroupe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<GroupeDTO>> getGroupesByClasseId(@PathVariable Long classeId) {
        List<GroupeDTO> groupes = groupeService.getGroupesByClasseId(classeId);
        return ResponseEntity.ok(groupes);
    }
}
