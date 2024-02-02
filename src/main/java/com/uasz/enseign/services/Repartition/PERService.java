package com.uasz.enseign.services.Repartition;

import com.uasz.enseign.dto.Repartition.PERDTO;

import java.util.List;

public interface PERService extends EnseignantService {

    List<PERDTO> getAllPERs();

    PERDTO getPERById(Long id);

    PERDTO createPER(PERDTO perDTO);

    PERDTO updatePER(Long id, PERDTO perDTO);

    void deletePER(Long id);
}
