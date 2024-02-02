package com.uasz.enseign.serviceImpl.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.mappers.Repartition.EnseignantMapper;
import com.uasz.enseign.model.Repartition.Enseignant;
import com.uasz.enseign.repository.Repartition.EnseignantRepository;
import com.uasz.enseign.services.Repartition.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;
    private final EnseignantMapper enseignantMapper;

    @Autowired
    public EnseignantServiceImpl(EnseignantRepository enseignantRepository, EnseignantMapper enseignantMapper) {
        this.enseignantRepository = enseignantRepository;
        this.enseignantMapper = enseignantMapper;
    }

    @Override
    public List<EnseignantDTO> getAllEnseignants() {
        return enseignantRepository.findAll().stream()
                .map(enseignantMapper::enseignantToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnseignantDTO getEnseignantById(Long id) {
        Optional<Enseignant> optionalEnseignant = enseignantRepository.findById(id);
        return optionalEnseignant.map(enseignantMapper::enseignantToDTO).orElse(null);
    }

    @Override
    public EnseignantDTO createEnseignant(EnseignantDTO enseignantDTO) {
        Enseignant enseignant = enseignantMapper.dtoToEnseignant(enseignantDTO);
        Enseignant savedEnseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.enseignantToDTO(savedEnseignant);
    }

    @Override
    public EnseignantDTO updateEnseignant(Long id, EnseignantDTO enseignantDTO) {
        Optional<Enseignant> optionalEnseignant = enseignantRepository.findById(id);
        if (optionalEnseignant.isPresent()) {
            Enseignant existingEnseignant = optionalEnseignant.get();
            enseignantMapper.updateEnseignantFromDTO(enseignantDTO, existingEnseignant);
            Enseignant updatedEnseignant = enseignantRepository.save(existingEnseignant);
            return enseignantMapper.enseignantToDTO(updatedEnseignant);
        }
        return null;
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }
}
