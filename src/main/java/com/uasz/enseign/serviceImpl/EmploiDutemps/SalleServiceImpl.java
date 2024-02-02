package com.uasz.enseign.serviceImpl.EmploiDutemps;

import com.uasz.enseign.dto.EmploiDuTemps.SalleDTO;
import com.uasz.enseign.mappers.EmploiDuTemps.SalleMapper;
import com.uasz.enseign.model.Emploie_Du_Temps.Salle;
import com.uasz.enseign.repository.EmploiDuTemps.SalleRepository;
import com.uasz.enseign.services.EmploiDuTemps.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;
    private final SalleMapper salleMapper;

    @Autowired
    public SalleServiceImpl(SalleRepository salleRepository, SalleMapper salleMapper) {
        this.salleRepository = salleRepository;
        this.salleMapper = salleMapper;
    }

    @Override
    public List<SalleDTO> getAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return salles.stream()
                .map(salleMapper::salleToSalleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalleDTO getSalleById(Long id) {
        Salle salle = salleRepository.findById(id).orElse(null);
        if (salle != null) {
            return salleMapper.salleToSalleDTO(salle);
        }
        return null; // Gérer le cas où la salle n'est pas trouvée
    }

    @Override
    public SalleDTO createSalle(SalleDTO salleDTO) {
        Salle salle = salleMapper.salleDTOToSalle(salleDTO);
        salle = salleRepository.save(salle);
        return salleMapper.salleToSalleDTO(salle);
    }

    @Override
    public SalleDTO updateSalle(Long id, SalleDTO salleDTO) {
        Salle existingSalle = salleRepository.findById(id).orElse(null);
        if (existingSalle != null) {
            existingSalle.setNumero(salleDTO.getNumero());
            existingSalle.setCapacity(salleDTO.getCapacity());
            existingSalle.setBatiment(salleMapper.batimentDTOToBatiment(salleDTO.getBatiment()));
            existingSalle = salleRepository.save(existingSalle);
            return salleMapper.salleToSalleDTO(existingSalle);
        }
        return null; // Gérer le cas où la salle n'est pas trouvée
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
