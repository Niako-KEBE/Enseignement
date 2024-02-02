package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.EnseignementDTO;

import java.util.List;

public interface EnseignementService {

    List<EnseignementDTO> getAllEnseignements();

    EnseignementDTO getEnseignementById(Long id);

    EnseignementDTO createEnseignement(EnseignementDTO enseignementDTO);

    EnseignementDTO updateEnseignement(Long id, EnseignementDTO enseignementDTO);

    void deleteEnseignement(Long id);

    List<EnseignementDTO> getEnseignementsByClasseId(Long classeId);

    List<EnseignementDTO> getEnseignementsByGroupeId(Long groupeId);

}
