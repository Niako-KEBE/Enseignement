package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.CycleDTO;
import java.util.List;

public interface CycleService {

    List<CycleDTO> getAllCycles();

    CycleDTO getCycleById(Long id);

    CycleDTO createCycle(CycleDTO cycleDTO);

    CycleDTO updateCycle(Long id, CycleDTO cycleDTO);

    void deleteCycle(Long id);

}
