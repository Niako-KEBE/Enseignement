package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.EnseignementDTO;
import com.uasz.enseign.mappers.Maquette.EnseignementMapper;
import com.uasz.enseign.model.Maquette.Classe;
import com.uasz.enseign.model.Maquette.Enseignement;
import com.uasz.enseign.model.Maquette.Groupe;
import com.uasz.enseign.repository.Maquette.EnseignementRepository;
import com.uasz.enseign.services.Maquette.EnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignementServiceImpl implements EnseignementService {

    private final EnseignementRepository enseignementRepository;
    private final EnseignementMapper enseignementMapper;

    @Autowired
    public EnseignementServiceImpl(EnseignementRepository enseignementRepository, EnseignementMapper enseignementMapper) {
        this.enseignementRepository = enseignementRepository;
        this.enseignementMapper = enseignementMapper;
    }

    @Override
    public List<EnseignementDTO> getAllEnseignements() {
        List<Enseignement> enseignements = enseignementRepository.findAll();
        return enseignementMapper.enseignementListToEnseignementDTOList(enseignements);
    }

    @Override
    public EnseignementDTO getEnseignementById(Long id) {
        Enseignement enseignement = enseignementRepository.findById(id).orElse(null);
        return enseignementMapper.enseignementToEnseignementDTO(enseignement);
    }

    @Override
    public EnseignementDTO createEnseignement(EnseignementDTO enseignementDTO) {
        Enseignement enseignement = enseignementMapper.enseignementDTOToEnseignement(enseignementDTO);
        Enseignement savedEnseignement = enseignementRepository.save(enseignement);
        return enseignementMapper.enseignementToEnseignementDTO(savedEnseignement);
    }

    @Override
    public EnseignementDTO updateEnseignement(Long id, EnseignementDTO enseignementDTO) {
        Enseignement existingEnseignement = enseignementRepository.findById(id).orElse(null);
        if (existingEnseignement != null) {
            existingEnseignement.setLibelle(enseignementDTO.getLibelle());
            existingEnseignement.setDescription(enseignementDTO.getDescription());
            // Mise à jour d'autres champs si nécessaire
            Enseignement updatedEnseignement = enseignementRepository.save(existingEnseignement);
            return enseignementMapper.enseignementToEnseignementDTO(updatedEnseignement);
        }
        return null; // Gérer le cas où l'enseignement n'est pas trouvé
    }

    @Override
    public void deleteEnseignement(Long id) {
        enseignementRepository.deleteById(id);
    }

    @Override
    public List<EnseignementDTO> getEnseignementsByClasseId(Long classeId) {
        Classe classe = new Classe();
        classe.setId(classeId);
        List<Enseignement> enseignements = enseignementRepository.findByClasse(classe);
        return enseignementMapper.enseignementListToEnseignementDTOList(enseignements);
    }

    @Override
    public List<EnseignementDTO> getEnseignementsByGroupeId(Long groupeId) {
        Groupe groupe = new Groupe();
        groupe.setId(groupeId);
        List<Enseignement> enseignements = enseignementRepository.findByGroupe(groupe);
        return enseignementMapper.enseignementListToEnseignementDTOList(enseignements);
    }
}
