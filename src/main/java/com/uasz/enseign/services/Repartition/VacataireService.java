package com.uasz.enseign.services.Repartition;

import com.uasz.enseign.dto.Repartition.VacataireDTO;

import java.util.List;

public interface VacataireService extends EnseignantService {

    List<VacataireDTO> getAllVacataires();

    VacataireDTO getVacataireById(Long id);

    VacataireDTO createVacataire(VacataireDTO vacataireDTO);

    VacataireDTO updateVacataire(Long id, VacataireDTO vacataireDTO);

    void deleteVacataire(Long id);

}
