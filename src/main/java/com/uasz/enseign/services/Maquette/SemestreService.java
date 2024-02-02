package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.SemestreDTO;

import java.util.List;

public interface SemestreService {

    List<SemestreDTO> getAllSemestres();

    SemestreDTO getSemestreById(Long id);

    SemestreDTO createSemestre(SemestreDTO semestreDTO);

    SemestreDTO updateSemestre(Long id, SemestreDTO semestreDTO);

    void deleteSemestre(Long id);

    List<SemestreDTO> getSemestresByClasseId(Long classeId);

    List<SemestreDTO> getSemestresByModuleId(Long moduleId);

}
