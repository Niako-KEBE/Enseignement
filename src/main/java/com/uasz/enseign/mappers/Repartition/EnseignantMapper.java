package com.uasz.enseign.mappers.Repartition;

import com.uasz.enseign.dto.Repartition.EnseignantDTO;
import com.uasz.enseign.model.Repartition.Enseignant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnseignantMapper {
    EnseignantMapper INSTANCE = Mappers.getMapper(EnseignantMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade")
    })
    EnseignantDTO enseignantToDTO(Enseignant enseignant);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade")
    })
    Enseignant dtoToEnseignant(EnseignantDTO dto);

    @Mappings({
            @Mapping(target = "nom", source = "dto.nom"),
            @Mapping(target = "prenom", source = "dto.prenom"),
            @Mapping(target = "grade", source = "dto.grade")
    })
    void updateEnseignantFromDTO(EnseignantDTO dto, @MappingTarget Enseignant enseignant);
}
