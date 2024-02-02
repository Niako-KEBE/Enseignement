package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.FormationDTO;

import java.util.List;

public interface FormationService {

    List<FormationDTO> getAllFormations();

    FormationDTO getFormationById(Long id);

    FormationDTO createFormation(FormationDTO formationDTO);

    FormationDTO updateFormation(Long id, FormationDTO formationDTO);

    void deleteFormation(Long id);

    List<FormationDTO> getFormationsByFiliereId(Long filiereId);

    List<FormationDTO> getFormationsByNiveauId(Long niveauId);

}
