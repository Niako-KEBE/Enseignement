package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.FiliereDTO;
import com.uasz.enseign.mappers.Maquette.FiliereMapper;
import com.uasz.enseign.model.Maquette.Filiere;
import com.uasz.enseign.model.Maquette.Formation;
import com.uasz.enseign.repository.Maquette.FiliereRepository;
import com.uasz.enseign.services.Maquette.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereServiceImpl implements FiliereService {

    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    @Autowired
    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    @Override
    public List<FiliereDTO> getAllFilieres() {
        List<Filiere> filiereList = filiereRepository.findAll();
        return filiereMapper.filiereListToFiliereDTOList(filiereList);
    }

    @Override
    public FiliereDTO getFiliereById(Long id) {
        Optional<Filiere> filiereOptional = filiereRepository.findById(id);
        return filiereOptional.map(filiereMapper::filiereToFiliereDTO).orElse(null);
    }

    @Override
    public FiliereDTO createFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = filiereMapper.filiereDTOToFiliere(filiereDTO);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.filiereToFiliereDTO(savedFiliere);
    }

    @Override
    public FiliereDTO updateFiliere(Long id, FiliereDTO filiereDTO) {
        Optional<Filiere> filiereOptional = filiereRepository.findById(id);

        if (filiereOptional.isPresent()) {
            Filiere filiere = filiereMapper.filiereDTOToFiliere(filiereDTO);
            filiere.setId(id); // Set the ID to update the existing entity
            Filiere updatedFiliere = filiereRepository.save(filiere);
            return filiereMapper.filiereToFiliereDTO(updatedFiliere);
        } else {
            return null; // Filiere with the given ID not found
        }
    }

    @Override
    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }

    @Override
    public List<FiliereDTO> getFilieresByFormationId(Long formationId) {
        Formation formation = new Formation();
        formation.setId(formationId);
        List<Filiere> filiereList = filiereRepository.findByFormation(formation);
        return filiereMapper.filiereListToFiliereDTOList(filiereList);
    }
}
