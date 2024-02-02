package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.CycleDTO;
import com.uasz.enseign.model.Maquette.Cycle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CycleMapper {
    CycleMapper INSTANCE = Mappers.getMapper(CycleMapper.class);

    @Mappings({
            @Mapping(source = "niveaux", target = "niveaux")
    })
    CycleDTO cycleToCycleDTO(Cycle cycle);

    @Mappings({
            @Mapping(source = "niveaux", target = "niveaux")
    })
    Cycle cycleDTOToCycle(CycleDTO cycleDTO);
}
