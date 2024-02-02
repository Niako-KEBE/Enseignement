package com.uasz.enseign.services.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;

import java.util.List;

public interface EnseignantService {

    List<EnseignantDTO> getAllEnseignants();

    EnseignantDTO getEnseignantById(Long id);

    EnseignantDTO createEnseignant(EnseignantDTO enseignantDTO);

    EnseignantDTO updateEnseignant(Long id, EnseignantDTO enseignantDTO);

    void deleteEnseignant(Long id);

}
