package com.uasz.enseign.serviceImpl.EmploiDutemps;

import com.uasz.enseign.dto.EmploiDuTemps.EmploiDTO;
import com.uasz.enseign.mappers.EmploiDuTemps.EmploiMapper;
import com.uasz.enseign.model.Emploie_Du_Temps.Emploi;
import com.uasz.enseign.repository.EmploiDuTemps.EmploiRepository;
import com.uasz.enseign.services.EmploiDuTemps.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmploiServiceImpl implements EmploiService {

    private final EmploiRepository emploiRepository;
    private final EmploiMapper emploiMapper;

    @Autowired
    public EmploiServiceImpl(EmploiRepository emploiRepository, EmploiMapper emploiMapper) {
        this.emploiRepository = emploiRepository;
        this.emploiMapper = emploiMapper;
    }

    @Override
    public List<EmploiDTO> getAllEmplois() {
        List<Emploi> emplois = emploiRepository.findAll();
        return emplois.stream()
                .map(emploiMapper::emploiToEmploiDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmploiDTO getEmploiById(Long id) {
        Emploi emploi = emploiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emploi not found with id: " + id));
        return emploiMapper.emploiToEmploiDTO(emploi);
    }

    @Override
    public EmploiDTO createEmploi(EmploiDTO emploiDTO) {
        Emploi emploi = emploiMapper.emploiDTOToEmploi(emploiDTO);
        Emploi savedEmploi = emploiRepository.save(emploi);
        return emploiMapper.emploiToEmploiDTO(savedEmploi);
    }

    @Override
    public EmploiDTO updateEmploi(Long id, EmploiDTO emploiDTO) {
        if (!emploiRepository.existsById(id)) {
            throw new IllegalArgumentException("Emploi not found with id: " + id);
        }
        Emploi emploi = emploiMapper.emploiDTOToEmploi(emploiDTO);
        emploi.setId(id);
        Emploi updatedEmploi = emploiRepository.save(emploi);
        return emploiMapper.emploiToEmploiDTO(updatedEmploi);
    }

    @Override
    public void deleteEmploi(Long id) {
        if (!emploiRepository.existsById(id)) {
            throw new IllegalArgumentException("Emploi not found with id: " + id);
        }
        emploiRepository.deleteById(id);
    }
}
