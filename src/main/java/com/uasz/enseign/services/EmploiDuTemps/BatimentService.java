package com.uasz.enseign.services.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;

import java.util.List;

public interface BatimentService {

    List<BatimentDTO> getAllBatiments();

    BatimentDTO getBatimentById(Long id);

    BatimentDTO createBatiment(BatimentDTO batimentDTO);

    BatimentDTO updateBatiment(Long id, BatimentDTO batimentDTO);

    void deleteBatiment(Long id);

}
