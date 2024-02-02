package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.FormationDTO;
import com.uasz.enseign.mappers.Maquette.FormationMapper;
import com.uasz.enseign.model.Maquette.Formation;
import com.uasz.enseign.model.Maquette.Filiere;
import com.uasz.enseign.model.Maquette.Niveau;
import com.uasz.enseign.repository.Maquette.FormationRepository;
import com.uasz.enseign.services.Maquette.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final FormationMapper formationMapper;

    @Autowired
    public FormationServiceImpl(FormationRepository formationRepository, FormationMapper formationMapper) {
        this.formationRepository = formationRepository;
        this.formationMapper = formationMapper;
    }

    @Override
    public List<FormationDTO> getAllFormations() {
        List<Formation> formationList = formationRepository.findAll();
        return formationMapper.formationListToFormationDTOList(formationList);
    }

    @Override
    public FormationDTO getFormationById(Long id) {
        Optional<Formation> formationOptional = formationRepository.findById(id);
        return formationOptional.map(formationMapper::formationToFormationDTO).orElse(null);
    }

    @Override
    public FormationDTO createFormation(FormationDTO formationDTO) {
        Formation formation = formationMapper.formationDTOToFormation(formationDTO);
        Formation savedFormation = formationRepository.save(formation);
        return formationMapper.formationToFormationDTO(savedFormation);
    }

    @Override
    public FormationDTO updateFormation(Long id, FormationDTO formationDTO) {
        Optional<Formation> formationOptional = formationRepository.findById(id);

        if (formationOptional.isPresent()) {
            Formation formation = formationMapper.formationDTOToFormation(formationDTO);
            formation.setId(id); // Set the ID to update the existing entity
            Formation updatedFormation = formationRepository.save(formation);
            return formationMapper.formationToFormationDTO(updatedFormation);
        } else {
            return null; // Formation with the given ID not found
        }
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<FormationDTO> getFormationsByFiliereId(Long filiereId) {
        Filiere filiere = new Filiere();
        filiere.setId(filiereId);
        List<Formation> formationList = formationRepository.findByFiliere(filiere);
        return formationMapper.formationListToFormationDTOList(formationList);
    }

    @Override
    public List<FormationDTO> getFormationsByNiveauId(Long niveauId) {
        Niveau niveau = new Niveau();
        niveau.setId(niveauId);
        List<Formation> formationList = formationRepository.findByNiveau(niveau);
        return formationMapper.formationListToFormationDTOList(formationList);
    }
}
