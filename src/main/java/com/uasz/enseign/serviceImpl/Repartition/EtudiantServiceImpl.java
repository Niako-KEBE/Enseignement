//package com.uasz.enseign.serviceImpl.Repartition;
//
//import com.uasz.enseign.dto.Repartition.EtudiantDTO;
//import com.uasz.enseign.entities.Maquette.Cycle;
//import com.uasz.enseign.entities.Maquette.Filiere;
//import com.uasz.enseign.entities.Maquette.Semestre;
//import com.uasz.enseign.entities.Repartition.Etudiant;
//import com.uasz.enseign.mappers.Repartition.EtudiantMapper;
//import com.uasz.enseign.repository.Repartition.EtudiantRepository;
//import com.uasz.enseign.services.Repartition.EtudiantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class EtudiantServiceImpl implements EtudiantService {
//
//    private final EtudiantRepository etudiantRepository;
//    private final EtudiantMapper etudiantMapper;
//
//    @Autowired
//    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
//        this.etudiantRepository = etudiantRepository;
//        this.etudiantMapper = etudiantMapper;
//    }
//
//    @Override
//    public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO) {
//        Etudiant etudiant = etudiantMapper.etudiantDTOToEtudiant(etudiantDTO);
//        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
//        return etudiantMapper.etudiantToEtudiantDTO(savedEtudiant);
//    }
//
//    @Override
//    public List<EtudiantDTO> afficherTousEtudiants() {
//        List<Etudiant> etudiants = (List<Etudiant>) etudiantRepository.findAll();
//        return etudiants.stream()
//                .map(etudiantMapper::etudiantToEtudiantDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public EtudiantDTO afficherEtudiant(Long idEtudiant) {
//        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(idEtudiant);
//        return optionalEtudiant.map(etudiantMapper::etudiantToEtudiantDTO).orElse(null);
//    }
//
//    @Override
//    public List<EtudiantDTO> chercherEtudiantsParNom(String nom) {
//        List<Etudiant> etudiants = etudiantRepository.findByNom(nom);
//        return etudiants.stream()
//                .map(etudiantMapper::etudiantToEtudiantDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<EtudiantDTO> chercherEtudiantsParPrenom(String prenom) {
//        List<Etudiant> etudiants = etudiantRepository.findByPrenom(prenom);
//        return etudiants.stream()
//                .map(etudiantMapper::etudiantToEtudiantDTO)
//                .collect(Collectors.toList());
//    }
//    @Override
//    public EtudiantDTO modifierEtudiant(EtudiantDTO etudiantDTO) {
//        // Vérifier si l'étudiant existe
//        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(etudiantDTO.getId());
//
//        if (optionalEtudiant.isPresent()) {
//            // L'étudiant existe, récupérer l'entité
//            Etudiant existingEtudiant = optionalEtudiant.get();
//
//            // Mettre à jour les propriétés avec les valeurs du DTO
//            existingEtudiant.setNom(etudiantDTO.getNom());
//            existingEtudiant.setPrenom(etudiantDTO.getPrenom());
//            existingEtudiant.setEmail(etudiantDTO.getEmail());
//            existingEtudiant.setAdresse(etudiantDTO.getAdresse());
//            existingEtudiant.setCycles((Collection<Cycle>) etudiantDTO.getCycle());
//            existingEtudiant.setFilieres((Collection<Filiere>) etudiantDTO.getFiliere());
//            existingEtudiant.setSemestres((Collection<Semestre>) etudiantDTO.getNiveau());
//
//            // Enregistrer l'entité mise à jour dans la base de données
//            Etudiant updatedEtudiant = etudiantRepository.save(existingEtudiant);
//
//            // Retourner le DTO correspondant à l'entité mise à jour
//            return etudiantMapper.etudiantToEtudiantDTO(updatedEtudiant);
//        } else {
//            // L'étudiant n'existe pas, vous pouvez choisir de lever une exception ou retourner null
//            return null;
//        }
//    }
//    @Override
//    public void supprimerEtudiant(Long idEtudiant) {
//        etudiantRepository.deleteById(idEtudiant);
//    }
//}
