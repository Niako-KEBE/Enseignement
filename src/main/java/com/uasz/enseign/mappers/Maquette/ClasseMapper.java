package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.ClasseDTO;
import com.uasz.enseign.model.Maquette.Classe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClasseMapper {
    ClasseMapper INSTANCE = Mappers.getMapper(ClasseMapper.class);

    @Mappings({
            @Mapping(source = "enseignement", target = "enseignement"),
            @Mapping(source = "semestre", target = "semestre"),
            @Mapping(source = "groupes", target = "groupes"),
            @Mapping(source = "formation", target = "formation")
    })
    ClasseDTO classeToClasseDTO(Classe classe);

    @Mappings({
            @Mapping(source = "enseignement", target = "enseignement"),
            @Mapping(source = "semestre", target = "semestre"),
            @Mapping(source = "groupes", target = "groupes"),
            @Mapping(source = "formation", target = "formation")
    })
    Classe classeDTOToClasse(ClasseDTO classeDTO);
}
