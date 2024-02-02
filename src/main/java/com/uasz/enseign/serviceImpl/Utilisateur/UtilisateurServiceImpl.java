package com.uasz.enseign.serviceImpl.Utilisateur;

import com.uasz.enseign.dto.Utilisateur.UtilisateurDTO;
import com.uasz.enseign.mappers.Utilisateur.UtilisateurMapper;
import com.uasz.enseign.model.Utilisateur.Utilisateur;
import com.uasz.enseign.repository.Utilisateur.UtilisateurRepository;
import com.uasz.enseign.services.Utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurMapper.utilisateursToUtilisateurDTOs(utilisateurs);
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.map(utilisateurMapper::utilisateurToUtilisateurDTO).orElse(null);
    }

    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.utilisateurDTOToUtilisateur(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.utilisateurToUtilisateurDTO(savedUtilisateur);
    }

    @Override
    public UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO) {
        Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findById(id);
        if (existingUtilisateurOptional.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOptional.get();
            existingUtilisateur.setNom(utilisateurDTO.getNom());
            existingUtilisateur.setPrenom(utilisateurDTO.getPrenom());
            existingUtilisateur.setRole(utilisateurDTO.getRole());
            // Mettez à jour d'autres champs au besoin

            Utilisateur updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);
            return utilisateurMapper.utilisateurToUtilisateurDTO(updatedUtilisateur);
        }
        return null;
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
