package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.FiliereDTO;

import java.util.List;

public interface FiliereService {

    List<FiliereDTO> getAllFilieres();

    FiliereDTO getFiliereById(Long id);

    FiliereDTO createFiliere(FiliereDTO filiereDTO);

    FiliereDTO updateFiliere(Long id, FiliereDTO filiereDTO);

    void deleteFiliere(Long id);

    List<FiliereDTO> getFilieresByFormationId(Long formationId);


}
