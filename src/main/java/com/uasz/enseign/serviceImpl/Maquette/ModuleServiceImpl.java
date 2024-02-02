package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.ModuleDTO;
import com.uasz.enseign.mappers.Maquette.ModuleMapper;
import com.uasz.enseign.model.Maquette.Module;
import com.uasz.enseign.model.Maquette.UE;
import com.uasz.enseign.model.Maquette.EC;
import com.uasz.enseign.model.Maquette.Semestre;
import com.uasz.enseign.repository.Maquette.ModuleRepository;
import com.uasz.enseign.services.Maquette.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    @Autowired
    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
    }

    @Override
    public List<ModuleDTO> getAllModules() {
        List<Module> moduleList = moduleRepository.findAll();
        return moduleMapper.moduleListToModuleDTOList(moduleList);
    }

    @Override
    public ModuleDTO getModuleById(Long id) {
        Optional<Module> moduleOptional = moduleRepository.findById(id);
        return moduleOptional.map(moduleMapper::moduleToModuleDTO).orElse(null);
    }

    @Override
    public ModuleDTO createModule(ModuleDTO moduleDTO) {
        Module module = moduleMapper.moduleDTOToModule(moduleDTO);
        Module savedModule = moduleRepository.save(module);
        return moduleMapper.moduleToModuleDTO(savedModule);
    }

    @Override
    public ModuleDTO updateModule(Long id, ModuleDTO moduleDTO) {
        Optional<Module> moduleOptional = moduleRepository.findById(id);

        if (moduleOptional.isPresent()) {
            Module module = moduleMapper.moduleDTOToModule(moduleDTO);
            module.setId(id); // Set the ID to update the existing entity
            Module updatedModule = moduleRepository.save(module);
            return moduleMapper.moduleToModuleDTO(updatedModule);
        } else {
            return null; // Module with the given ID not found
        }
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    @Override
    public List<ModuleDTO> getModulesByUeId(Long ueId) {
        UE ue = new UE();
        ue.setId(ueId);
        List<Module> moduleList = moduleRepository.findByUe(ue);
        return moduleMapper.moduleListToModuleDTOList(moduleList);
    }

    @Override
    public List<ModuleDTO> getModulesByEcId(Long ecId) {
        EC ec = new EC();
        ec.setId(ecId);
        List<Module> moduleList = moduleRepository.findByEc(ec);
        return moduleMapper.moduleListToModuleDTOList(moduleList);
    }

    @Override
    public List<ModuleDTO> getModulesBySemestreId(Long semestreId) {
        Semestre semestre = new Semestre();
        semestre.setId(semestreId);
        List<Module> moduleList = moduleRepository.findBySemestre(semestre);
        return moduleMapper.moduleListToModuleDTOList(moduleList);
    }

}
