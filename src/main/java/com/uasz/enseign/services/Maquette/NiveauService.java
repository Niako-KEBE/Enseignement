package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.NiveauDTO;

import java.util.List;

public interface NiveauService {

    List<NiveauDTO> getAllNiveaux();

    NiveauDTO getNiveauById(Long id);

    NiveauDTO createNiveau(NiveauDTO niveauDTO);

    NiveauDTO updateNiveau(Long id, NiveauDTO niveauDTO);

    void deleteNiveau(Long id);

    List<NiveauDTO> getNiveauxByCycleId(Long cycleId);

}
