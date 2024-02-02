package com.uasz.enseign.serviceImpl.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.dto.Repartition.VacataireDTO;
import com.uasz.enseign.mappers.Repartition.VacataireMapper;
import com.uasz.enseign.model.Repartition.Vacataire;
import com.uasz.enseign.repository.Repartition.VacataireRepository;
import com.uasz.enseign.services.Repartition.VacataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacataireServiceImpl implements VacataireService {

    private final VacataireRepository vacataireRepository;
    private final VacataireMapper vacataireMapper;

    @Autowired
    public VacataireServiceImpl(VacataireRepository vacataireRepository, VacataireMapper vacataireMapper) {
        this.vacataireRepository = vacataireRepository;
        this.vacataireMapper = vacataireMapper;
    }

    @Override
    public List<VacataireDTO> getAllVacataires() {
        List<Vacataire> vacataires = vacataireRepository.findAll();
        return vacataires.stream()
                .map(vacataireMapper::vacataireToVacataireDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VacataireDTO getVacataireById(Long id) {
        Optional<Vacataire> vacataire = vacataireRepository.findById(id);
        return vacataire.map(vacataireMapper::vacataireToVacataireDTO).orElse(null);
    }

    @Override
    public VacataireDTO createVacataire(VacataireDTO vacataireDTO) {
        Vacataire vacataire = vacataireMapper.vacataireDTOToVacataire(vacataireDTO);
        Vacataire savedVacataire = vacataireRepository.save(vacataire);
        return vacataireMapper.vacataireToVacataireDTO(savedVacataire);
    }

    @Override
    public VacataireDTO updateVacataire(Long id, VacataireDTO vacataireDTO) {
        Optional<Vacataire> existingVacataire = vacataireRepository.findById(id);

        if (existingVacataire.isPresent()) {
            Vacataire vacataire = existingVacataire.get();
            vacataireMapper.updateEnseignantFromDTO(vacataireDTO, vacataire);
            Vacataire updatedVacataire = vacataireRepository.save(vacataire);
            return vacataireMapper.vacataireToVacataireDTO(updatedVacataire);
        }


        return null; // Handle the case where the Vacataire with the given id is not found
    }

    @Override
    public void deleteVacataire(Long id) {
        vacataireRepository.deleteById(id);
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
