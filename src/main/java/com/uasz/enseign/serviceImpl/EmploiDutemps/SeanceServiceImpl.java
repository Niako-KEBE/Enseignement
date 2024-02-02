package com.uasz.enseign.serviceImpl.EmploiDutemps;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import com.uasz.enseign.mappers.EmploiDuTemps.SeanceMapper;
import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import com.uasz.enseign.repository.EmploiDuTemps.SeanceRepository;
import com.uasz.enseign.services.EmploiDuTemps.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final SeanceMapper seanceMapper;

    @Autowired
    public SeanceServiceImpl(SeanceRepository seanceRepository, SeanceMapper seanceMapper) {
        this.seanceRepository = seanceRepository;
        this.seanceMapper = seanceMapper;
    }

    @Override
    public List<SeanceDTO> getAllSeances() {
        List<Seance> seances = seanceRepository.findAll();
        return seances.stream()
                .map(seanceMapper::seanceToSeanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeanceDTO getSeanceById(Long id) {
        Seance seance = seanceRepository.findById(id).orElse(null);
        return (seance != null) ? seanceMapper.seanceToSeanceDTO(seance) : null;
    }

    @Override
    public SeanceDTO createSeance(SeanceDTO seanceDTO) {
        Seance seance = seanceMapper.seanceDTOToSeance(seanceDTO);
        Seance savedSeance = seanceRepository.save(seance);
        return seanceMapper.seanceToSeanceDTO(savedSeance);
    }

    @Override
    public SeanceDTO updateSeance(Long id, SeanceDTO seanceDTO) {
        // Vérifier si la séance existe avant de la mettre à jour
        if (!seanceRepository.existsById(id)) {
            return null;
        }

        Seance seanceToUpdate = seanceMapper.seanceDTOToSeance(seanceDTO);
        seanceToUpdate.setId(id);

        Seance updatedSeance = seanceRepository.save(seanceToUpdate);
        return seanceMapper.seanceToSeanceDTO(updatedSeance);
    }

    @Override
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }
}
