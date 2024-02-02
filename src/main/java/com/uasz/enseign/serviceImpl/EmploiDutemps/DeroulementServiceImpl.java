package com.uasz.enseign.serviceImpl.EmploiDutemps;

import com.uasz.enseign.dto.EmploiDuTemps.DeroulementDTO;
import com.uasz.enseign.mappers.EmploiDuTemps.DeroulementMapper;
import com.uasz.enseign.model.Emploie_Du_Temps.Deroulement;
import com.uasz.enseign.repository.EmploiDuTemps.DeroulementRepository;
import com.uasz.enseign.services.EmploiDuTemps.DeroulementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeroulementServiceImpl implements DeroulementService {

    private final DeroulementRepository deroulementRepository;
    private final DeroulementMapper deroulementMapper;

    @Autowired
    public DeroulementServiceImpl(DeroulementRepository deroulementRepository, DeroulementMapper deroulementMapper) {
        this.deroulementRepository = deroulementRepository;
        this.deroulementMapper = deroulementMapper;
    }

    @Override
    public List<DeroulementDTO> getAllDeroulements() {
        List<Deroulement> deroulements = deroulementRepository.findAll();
        return deroulements.stream()
                .map(deroulementMapper::deroulementToDeroulementDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeroulementDTO getDeroulementById(Long id) {
        Optional<Deroulement> optionalDeroulement = deroulementRepository.findById(id);
        return optionalDeroulement.map(deroulementMapper::deroulementToDeroulementDTO).orElse(null);
    }

    @Override
    public DeroulementDTO createDeroulement(DeroulementDTO deroulementDTO) {
        Deroulement deroulement = deroulementMapper.deroulementDTOToDeroulement(deroulementDTO);
        Deroulement savedDeroulement = deroulementRepository.save(deroulement);
        return deroulementMapper.deroulementToDeroulementDTO(savedDeroulement);
    }

    @Override
    public DeroulementDTO updateDeroulement(Long id, DeroulementDTO deroulementDTO) {
        Optional<Deroulement> optionalDeroulement = deroulementRepository.findById(id);
        if (optionalDeroulement.isPresent()) {
            Deroulement deroulementToUpdate = optionalDeroulement.get();
            deroulementMapper.updateDeroulementFromDTO(deroulementDTO, deroulementToUpdate);
            Deroulement updatedDeroulement = deroulementRepository.save(deroulementToUpdate);
            return deroulementMapper.deroulementToDeroulementDTO(updatedDeroulement);
        }
        return null;
    }

    @Override
    public void deleteDeroulement(Long id) {
        deroulementRepository.deleteById(id);
    }
}
