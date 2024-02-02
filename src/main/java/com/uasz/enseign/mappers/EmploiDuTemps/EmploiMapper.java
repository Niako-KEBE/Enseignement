package com.uasz.enseign.mappers.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.EmploiDTO;
import com.uasz.enseign.model.Emploie_Du_Temps.Emploi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploiMapper {
    EmploiMapper INSTANCE = Mappers.getMapper(EmploiMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "duree", source = "duree"),
            @Mapping(target = "debut", source = "debut"),
            @Mapping(target = "fin", source = "fin"),
            @Mapping(target = "seances", source = "seances")
    })
    EmploiDTO emploiToEmploiDTO(Emploi emploi);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "duree", source = "duree"),
            @Mapping(target = "debut", source = "debut"),
            @Mapping(target = "fin", source = "fin"),
            @Mapping(target = "seances", source = "seances")
    })
    Emploi emploiDTOToEmploi(EmploiDTO emploiDTO);
}
