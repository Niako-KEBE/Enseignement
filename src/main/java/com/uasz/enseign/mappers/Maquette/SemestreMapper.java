package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.SemestreDTO;
import com.uasz.enseign.model.Maquette.Semestre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SemestreMapper {
    SemestreMapper INSTANCE = Mappers.getMapper(SemestreMapper.class);

    @Mappings({
            @Mapping(source = "classes", target = "classes"),
            @Mapping(source = "modules", target = "modules")
    })
    SemestreDTO semestreToSemestreDTO(Semestre semestre);

    @Mappings({
            @Mapping(source = "classes", target = "classes"),
            @Mapping(source = "modules", target = "modules")
    })
    Semestre semestreDTOToSemestre(SemestreDTO semestreDTO);
}
