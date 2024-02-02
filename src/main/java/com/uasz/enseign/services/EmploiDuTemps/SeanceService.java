package com.uasz.enseign.services.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;

import java.util.List;

public interface SeanceService {

    List<SeanceDTO> getAllSeances();

    SeanceDTO getSeanceById(Long id);

    SeanceDTO createSeance(SeanceDTO seanceDTO);

    SeanceDTO updateSeance(Long id, SeanceDTO seanceDTO);

    void deleteSeance(Long id);


}
