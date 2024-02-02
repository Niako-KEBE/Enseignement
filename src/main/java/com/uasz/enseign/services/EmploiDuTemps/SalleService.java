package com.uasz.enseign.services.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SalleDTO;

import java.util.List;

public interface SalleService {

    List<SalleDTO> getAllSalles();

    SalleDTO getSalleById(Long id);

    SalleDTO createSalle(SalleDTO salleDTO);

    SalleDTO updateSalle(Long id, SalleDTO salleDTO);

    void deleteSalle(Long id);

}
