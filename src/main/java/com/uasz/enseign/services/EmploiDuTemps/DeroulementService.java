package com.uasz.enseign.services.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.DeroulementDTO;

import java.util.List;

public interface DeroulementService {

    List<DeroulementDTO> getAllDeroulements();

    DeroulementDTO getDeroulementById(Long id);

    DeroulementDTO createDeroulement(DeroulementDTO deroulementDTO);

    DeroulementDTO updateDeroulement(Long id, DeroulementDTO deroulementDTO);

    void deleteDeroulement(Long id);

}
