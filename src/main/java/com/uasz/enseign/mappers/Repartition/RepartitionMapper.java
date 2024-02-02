package com.uasz.enseign.mappers.Repartition;

import com.uasz.enseign.dto.Repartition.RepartitionDTO;
import com.uasz.enseign.model.Repartition.Repartition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepartitionMapper {
    RepartitionMapper INSTANCE = Mappers.getMapper(RepartitionMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "classe", source = "classe"),
            @Mapping(target = "effectif", source = "effectif"),
            @Mapping(target = "semestre", source = "semestre"),
            @Mapping(target = "enseignement", source = "enseignement"),
            @Mapping(target = "credit", source = "credit"),
            @Mapping(target = "dureeCours", source = "dureeCours"),
            @Mapping(target = "enseignant", source = "enseignant"),
            @Mapping(target = "cm", source = "cm"),
            @Mapping(target = "responsableTD", source = "responsableTD"),
            @Mapping(target = "responsableTP", source = "responsableTP"),
            @Mapping(target = "travauxDirige", source = "travauxDirige"),
            @Mapping(target = "travauxPratique", source = "travauxPratique"),
            @Mapping(target = "seances", source = "seances")
    })
    RepartitionDTO repartitionToRepartitionDTO(Repartition repartition);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "classe", source = "classe"),
            @Mapping(target = "effectif", source = "effectif"),
            @Mapping(target = "semestre", source = "semestre"),
            @Mapping(target = "enseignement", source = "enseignement"),
            @Mapping(target = "credit", source = "credit"),
            @Mapping(target = "dureeCours", source = "dureeCours"),
            @Mapping(target = "enseignant", source = "enseignant"),
            @Mapping(target = "cm", source = "cm"),
            @Mapping(target = "responsableTD", source = "responsableTD"),
            @Mapping(target = "responsableTP", source = "responsableTP"),
            @Mapping(target = "travauxDirige", source = "travauxDirige"),
            @Mapping(target = "travauxPratique", source = "travauxPratique"),
            @Mapping(target = "seances", source = "seances")
    })
    Repartition repartitionDTOToRepartition(RepartitionDTO repartitionDTO);

    void updateRepartitionFromDTO(RepartitionDTO repartitionDTO, Repartition repartition);
}
