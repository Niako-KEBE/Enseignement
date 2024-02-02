package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.MaquetteDTO;
import com.uasz.enseign.mappers.Maquette.MaquetteMapper;
import com.uasz.enseign.model.Maquette.Maquette;
import com.uasz.enseign.model.Maquette.Formation;
import com.uasz.enseign.repository.Maquette.MaquetteRepository;
import com.uasz.enseign.services.Maquette.MaquetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaquetteServiceImpl implements MaquetteService {

    private final MaquetteRepository maquetteRepository;
    private final MaquetteMapper maquetteMapper;

    @Autowired
    public MaquetteServiceImpl(MaquetteRepository maquetteRepository, MaquetteMapper maquetteMapper) {
        this.maquetteRepository = maquetteRepository;
        this.maquetteMapper = maquetteMapper;
    }

    @Override
    public List<MaquetteDTO> getAllMaquettes() {
        List<Maquette> maquetteList = maquetteRepository.findAll();
        return maquetteMapper.maquetteListToMaquetteDTOList(maquetteList);
    }

    @Override
    public MaquetteDTO getMaquetteById(Long id) {
        Optional<Maquette> maquetteOptional = maquetteRepository.findById(id);
        return maquetteOptional.map(maquetteMapper::maquetteToMaquetteDTO).orElse(null);
    }

    @Override
    public MaquetteDTO createMaquette(MaquetteDTO maquetteDTO) {
        Maquette maquette = maquetteMapper.maquetteDTOToMaquette(maquetteDTO);
        Maquette savedMaquette = maquetteRepository.save(maquette);
        return maquetteMapper.maquetteToMaquetteDTO(savedMaquette);
    }

    @Override
    public MaquetteDTO updateMaquette(Long id, MaquetteDTO maquetteDTO) {
        Optional<Maquette> maquetteOptional = maquetteRepository.findById(id);

        if (maquetteOptional.isPresent()) {
            Maquette maquette = maquetteMapper.maquetteDTOToMaquette(maquetteDTO);
            maquette.setId(id); // Set the ID to update the existing entity
            Maquette updatedMaquette = maquetteRepository.save(maquette);
            return maquetteMapper.maquetteToMaquetteDTO(updatedMaquette);
        } else {
            return null; // Maquette with the given ID not found
        }
    }

    @Override
    public void deleteMaquette(Long id) {
        maquetteRepository.deleteById(id);
    }

    @Override
    public List<MaquetteDTO> getMaquettesByFormationId(Long formationId) {
        Formation formation = new Formation();
        formation.setId(formationId);
        List<Maquette> maquetteList = maquetteRepository.findByFormation(formation);
        return maquetteMapper.maquetteListToMaquetteDTOList(maquetteList);
    }

}
