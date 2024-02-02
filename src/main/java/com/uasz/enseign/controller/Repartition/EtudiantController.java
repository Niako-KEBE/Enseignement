//package com.uasz.enseign.controller.Repartition;
//import com.uasz.enseign.dto.Repartition.EtudiantDTO;
//import com.uasz.enseign.services.Repartition.EtudiantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/etudiants")
//public class EtudiantController {
//
//    private final EtudiantService etudiantService;
//
//    @Autowired
//    public EtudiantController(EtudiantService etudiantService) {
//        this.etudiantService = etudiantService;
//    }
//
//    @PostMapping
//    public ResponseEntity<EtudiantDTO> saveEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
//        EtudiantDTO savedEtudiant = etudiantService.saveEtudiant(etudiantDTO);
//        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<EtudiantDTO>> afficherTousEtudiants() {
//        List<EtudiantDTO> etudiants = etudiantService.afficherTousEtudiants();
//        return new ResponseEntity<>(etudiants, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EtudiantDTO> afficherEtudiant(@PathVariable Long id) {
//        EtudiantDTO etudiant = etudiantService.afficherEtudiant(id);
//        if (etudiant != null) {
//            return new ResponseEntity<>(etudiant, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/chercher/nom/{nom}")
//    public ResponseEntity<List<EtudiantDTO>> chercherEtudiantsParNom(@PathVariable String nom) {
//        List<EtudiantDTO> etudiants = etudiantService.chercherEtudiantsParNom(nom);
//        return new ResponseEntity<>(etudiants, HttpStatus.OK);
//    }
//
//    @GetMapping("/chercher/prenom/{prenom}")
//    public ResponseEntity<List<EtudiantDTO>> chercherEtudiantsParPrenom(@PathVariable String prenom) {
//        List<EtudiantDTO> etudiants = etudiantService.chercherEtudiantsParPrenom(prenom);
//        return new ResponseEntity<>(etudiants, HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<EtudiantDTO> modifierEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
//        EtudiantDTO updatedEtudiant = etudiantService.modifierEtudiant(etudiantDTO);
//        if (updatedEtudiant != null) {
//            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> supprimerEtudiant(@PathVariable Long id) {
//        etudiantService.supprimerEtudiant(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
