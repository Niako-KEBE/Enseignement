package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.MaquetteDTO;

import java.util.List;

public interface MaquetteService {

    List<MaquetteDTO> getAllMaquettes();

    MaquetteDTO getMaquetteById(Long id);

    MaquetteDTO createMaquette(MaquetteDTO maquetteDTO);

    MaquetteDTO updateMaquette(Long id, MaquetteDTO maquetteDTO);

    void deleteMaquette(Long id);

    List<MaquetteDTO> getMaquettesByFormationId(Long formationId);

}
