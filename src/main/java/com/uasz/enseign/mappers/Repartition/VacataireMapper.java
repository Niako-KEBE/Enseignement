package com.uasz.enseign.mappers.Repartition;

import com.uasz.enseign.dto.Repartition.VacataireDTO;
import com.uasz.enseign.model.Repartition.Vacataire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VacataireMapper {
    VacataireMapper INSTANCE = Mappers.getMapper(VacataireMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"), // Les champs communs peuvent être mappés directement
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade"),
            @Mapping(target = "specialite", source = "specialite"),
            @Mapping(target = "contrat", source = "contrat"),
            @Mapping(target = "heuresEnseignement", source = "heuresEnseignement")
    })
    VacataireDTO vacataireToVacataireDTO(Vacataire vacataire);

    @Mappings({
            @Mapping(target = "id", source = "id"), // Les champs communs peuvent être mappés directement
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade"),
            @Mapping(target = "specialite", source = "specialite"),
            @Mapping(target = "contrat", source = "contrat"),
            @Mapping(target = "heuresEnseignement", source = "heuresEnseignement")
    })
    Vacataire vacataireDTOToVacataire(VacataireDTO vacataireDTO);

    void updateEnseignantFromDTO(VacataireDTO vacataireDTO, Vacataire vacataire);
}

