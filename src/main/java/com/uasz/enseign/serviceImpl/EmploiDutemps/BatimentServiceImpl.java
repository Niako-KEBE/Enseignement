package com.uasz.enseign.serviceImpl.EmploiDutemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;
import com.uasz.enseign.mappers.EmploiDuTemps.BatimentMapper;
import com.uasz.enseign.model.Emploie_Du_Temps.Batiment;
import com.uasz.enseign.repository.EmploiDuTemps.BatimentRepository;
import com.uasz.enseign.services.EmploiDuTemps.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatimentServiceImpl implements BatimentService {

    private final BatimentRepository batimentRepository;
    private final BatimentMapper batimentMapper;

    @Autowired
    public BatimentServiceImpl(BatimentRepository batimentRepository, BatimentMapper batimentMapper) {
        this.batimentRepository = batimentRepository;
        this.batimentMapper = batimentMapper;
    }

    @Override
    public List<BatimentDTO> getAllBatiments() {
        List<Batiment> batiments = batimentRepository.findAll();
        return batiments.stream()
                .map(batimentMapper::batimentToBatimentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatimentDTO getBatimentById(Long id) {
        Optional<Batiment> batimentOptional = batimentRepository.findById(id);
        return batimentOptional.map(batimentMapper::batimentToBatimentDTO).orElse(null);
    }

    @Override
    public BatimentDTO createBatiment(BatimentDTO batimentDTO) {
        Batiment batiment = batimentMapper.batimentDTOToBatiment(batimentDTO);
        Batiment savedBatiment = batimentRepository.save(batiment);
        return batimentMapper.batimentToBatimentDTO(savedBatiment);
    }

    @Override
    public BatimentDTO updateBatiment(Long id, BatimentDTO batimentDTO) {
        Optional<Batiment> existingBatimentOptional = batimentRepository.findById(id);
        if (existingBatimentOptional.isPresent()) {
            Batiment existingBatiment = existingBatimentOptional.get();
            // Update fields from DTO
            existingBatiment.setNom(batimentDTO.getNom());
            existingBatiment.setSalles(batimentMapper.batimentDTOToBatiment(batimentDTO).getSalles());
            // Save and return updated Batiment
            Batiment updatedBatiment = batimentRepository.save(existingBatiment);
            return batimentMapper.batimentToBatimentDTO(updatedBatiment);
        } else {
            return null; // Batiment not found
        }
    }

    @Override
    public void deleteBatiment(Long id) {
        batimentRepository.deleteById(id);
    }
}
