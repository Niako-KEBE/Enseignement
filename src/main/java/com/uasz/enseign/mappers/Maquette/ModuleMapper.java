package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.ModuleDTO;
import com.uasz.enseign.model.Maquette.Module;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ModuleMapper {
    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    @Mappings({
            @Mapping(source = "ue", target = "ue"),
            @Mapping(source = "ec", target = "ec"),
            @Mapping(source = "semestre", target = "semestre"),
            @Mapping(source = "enseignements", target = "enseignements"),
            @Mapping(source = "maquette", target = "maquette")
    })
    ModuleDTO moduleToModuleDTO(Module module);

    @Mappings({
            @Mapping(source = "ue", target = "ue"),
            @Mapping(source = "ec", target = "ec"),
            @Mapping(source = "semestre", target = "semestre"),
            @Mapping(source = "enseignements", target = "enseignements"),
            @Mapping(source = "maquette", target = "maquette")
    })
    Module moduleDTOToModule(ModuleDTO moduleDTO);

    List<ModuleDTO> moduleListToModuleDTOList(List<Module> moduleList);
}
