package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.ModuleDTO;

import java.util.List;

public interface ModuleService {

    List<ModuleDTO> getAllModules();

    ModuleDTO getModuleById(Long id);

    ModuleDTO createModule(ModuleDTO moduleDTO);

    ModuleDTO updateModule(Long id, ModuleDTO moduleDTO);

    void deleteModule(Long id);

    List<ModuleDTO> getModulesByUeId(Long ueId);

    List<ModuleDTO> getModulesByEcId(Long ecId);

    List<ModuleDTO> getModulesBySemestreId(Long semestreId);

}
