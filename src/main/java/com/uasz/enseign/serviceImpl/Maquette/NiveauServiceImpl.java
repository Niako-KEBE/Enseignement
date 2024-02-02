package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.NiveauDTO;
import com.uasz.enseign.mappers.Maquette.NiveauMapper;
import com.uasz.enseign.model.Maquette.Niveau;
import com.uasz.enseign.model.Maquette.Cycle;
import com.uasz.enseign.repository.Maquette.NiveauRepository;
import com.uasz.enseign.services.Maquette.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServiceImpl implements NiveauService {

    private final NiveauRepository niveauRepository;
    private final NiveauMapper niveauMapper;

    @Autowired
    public NiveauServiceImpl(NiveauRepository niveauRepository, NiveauMapper niveauMapper) {
        this.niveauRepository = niveauRepository;
        this.niveauMapper = niveauMapper;
    }

    @Override
    public List<NiveauDTO> getAllNiveaux() {
        List<Niveau> niveauList = niveauRepository.findAll();
        return niveauMapper.niveauListToNiveauDTOList(niveauList);
    }

    @Override
    public NiveauDTO getNiveauById(Long id) {
        Optional<Niveau> niveauOptional = niveauRepository.findById(id);
        return niveauOptional.map(niveauMapper::niveauToNiveauDTO).orElse(null);
    }

    @Override
    public NiveauDTO createNiveau(NiveauDTO niveauDTO) {
        Niveau niveau = niveauMapper.niveauDTOToNiveau(niveauDTO);
        Niveau savedNiveau = niveauRepository.save(niveau);
        return niveauMapper.niveauToNiveauDTO(savedNiveau);
    }

    @Override
    public NiveauDTO updateNiveau(Long id, NiveauDTO niveauDTO) {
        Optional<Niveau> niveauOptional = niveauRepository.findById(id);

        if (niveauOptional.isPresent()) {
            Niveau niveau = niveauMapper.niveauDTOToNiveau(niveauDTO);
            niveau.setId(id); // Set the ID to update the existing entity
            Niveau updatedNiveau = niveauRepository.save(niveau);
            return niveauMapper.niveauToNiveauDTO(updatedNiveau);
        } else {
            return null; // Niveau with the given ID not found
        }
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauRepository.deleteById(id);
    }

    @Override
    public List<NiveauDTO> getNiveauxByCycleId(Long cycleId) {
        Cycle cycle = new Cycle();
        cycle.setId(cycleId);
        List<Niveau> niveauList = niveauRepository.findByCycle(cycle);
        return niveauMapper.niveauListToNiveauDTOList(niveauList);
    }

    // Vous pouvez ajouter d'autres méthodes de service personnalisées selon vos besoins
}
