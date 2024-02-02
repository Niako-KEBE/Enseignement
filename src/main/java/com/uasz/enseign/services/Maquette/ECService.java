package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.ECDTO;

import java.util.List;

public interface ECService {

    List<ECDTO> getAllECs();

    ECDTO getECById(Long id);

    ECDTO createEC(ECDTO ecDTO);

    ECDTO updateEC(Long id, ECDTO ecDTO);

    void deleteEC(Long id);

    List<ECDTO> getECsByUeId(Long ueId);

    List<ECDTO> getECsByModuleId(Long moduleId);

    List<ECDTO> getECsBySemestreId(Long semestreId);

}
