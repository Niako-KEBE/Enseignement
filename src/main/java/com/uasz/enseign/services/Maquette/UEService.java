package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.UEDTO;

import java.util.List;

public interface UEService {

    List<UEDTO> getAllUEs();

    UEDTO getUEById(Long id);

    UEDTO createUE(UEDTO ueDTO);

    UEDTO updateUE(Long id, UEDTO ueDTO);

    void deleteUE(Long id);

    List<UEDTO> getUEsByUtilisateurId(Long utilisateurId);

}
