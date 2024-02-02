package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.MaquetteDTO;
import com.uasz.enseign.model.Maquette.Maquette;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MaquetteMapper {
    MaquetteMapper INSTANCE = Mappers.getMapper(MaquetteMapper.class);

    @Mappings({
            @Mapping(source = "formation", target = "formation"),
            @Mapping(source = "modules", target = "modules")
    })
    MaquetteDTO maquetteToMaquetteDTO(Maquette maquette);

    @Mappings({
            @Mapping(source = "formation", target = "formation"),
            @Mapping(source = "modules", target = "modules")
    })
    Maquette maquetteDTOToMaquette(MaquetteDTO maquetteDTO);

    List<MaquetteDTO> maquetteListToMaquetteDTOList(List<Maquette> maquetteList);
}
