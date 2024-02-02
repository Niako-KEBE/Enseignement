package com.uasz.enseign.mappers.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.DeroulementDTO;
import com.uasz.enseign.model.Emploie_Du_Temps.Deroulement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeroulementMapper {
    DeroulementMapper INSTANCE = Mappers.getMapper(DeroulementMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "matiere", source = "matiere"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "processus", source = "processus"),
            @Mapping(target = "seance", source = "seance")
    })
    DeroulementDTO deroulementToDeroulementDTO(Deroulement deroulement);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "matiere", source = "matiere"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "processus", source = "processus"),
            @Mapping(target = "seance", source = "seance")
    })
    Deroulement deroulementDTOToDeroulement(DeroulementDTO deroulementDTO);

    void updateDeroulementFromDTO(DeroulementDTO deroulementDTO, Deroulement deroulementToUpdate);
}
