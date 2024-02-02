package com.uasz.enseign.serviceImpl.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.dto.Repartition.PERDTO;
import com.uasz.enseign.mappers.Repartition.PERMapper;
import com.uasz.enseign.model.Repartition.PER;
import com.uasz.enseign.repository.Repartition.PERRepository;
import com.uasz.enseign.services.Repartition.PERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PERServiceImpl implements PERService {

    private final PERRepository perRepository;
    private final PERMapper perMapper;

    @Autowired
    public PERServiceImpl(PERRepository perRepository, PERMapper perMapper) {
        this.perRepository = perRepository;
        this.perMapper = perMapper;
    }

    @Override
    public List<PERDTO> getAllPERs() {
        return perRepository.findAll().stream()
                .map(perMapper::perToPERDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PERDTO getPERById(Long id) {
        Optional<PER> optionalPER = perRepository.findById(id);
        return optionalPER.map(perMapper::perToPERDTO).orElse(null);
    }

    @Override
    public PERDTO createPER(PERDTO perDTO) {
        PER per = perMapper.perDTOToPER(perDTO);
        PER savedPER = perRepository.save(per);
        return perMapper.perToPERDTO(savedPER);
    }

    @Override
    public PERDTO updatePER(Long id, PERDTO perDTO) {
        Optional<PER> optionalPER = perRepository.findById(id);
        if (optionalPER.isPresent()) {
            PER existingPER = optionalPER.get();
            perMapper.updateEnseignantFromDTO(perDTO, existingPER);
            existingPER.setMatricule(perDTO.getMatricule());
            existingPER.setStatut(perDTO.getStatut());
            existingPER.setAnciennete(perDTO.getAnciennete());
            PER updatedPER = perRepository.save(existingPER);
            return perMapper.perToPERDTO(updatedPER);
        }
        return null;
    }

    @Override
    public void deletePER(Long id) {
        perRepository.deleteById(id);
    }

    @Override
    public List<EnseignantDTO> getAllEnseignants() {
        return null;
    }

    @Override
    public EnseignantDTO getEnseignantById(Long id) {
        return null;
    }

    @Override
    public EnseignantDTO createEnseignant(EnseignantDTO enseignantDTO) {
        return null;
    }

    @Override
    public EnseignantDTO updateEnseignant(Long id, EnseignantDTO enseignantDTO) {
        return null;
    }

    @Override
    public void deleteEnseignant(Long id) {

    }
}
