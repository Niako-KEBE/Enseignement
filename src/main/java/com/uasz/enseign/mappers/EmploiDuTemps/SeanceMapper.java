package com.uasz.enseign.mappers.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.SeanceDTO;
import com.uasz.enseign.model.Emploie_Du_Temps.Seance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeanceMapper {
    SeanceMapper INSTANCE = Mappers.getMapper(SeanceMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "titre", source = "titre"),
            @Mapping(target = "dateDebut", source = "dateDebut"),
            @Mapping(target = "dateFin", source = "dateFin"),
            @Mapping(target = "emploi", source = "emploi"),
            @Mapping(target = "deroulement", source = "deroulement"),
            @Mapping(target = "repartition", source = "repartition")
    })
    SeanceDTO seanceToSeanceDTO(Seance seance);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "titre", source = "titre"),
            @Mapping(target = "dateDebut", source = "dateDebut"),
            @Mapping(target = "dateFin", source = "dateFin"),
            @Mapping(target = "emploi", source = "emploi"),
            @Mapping(target = "deroulement", source = "deroulement"),
            @Mapping(target = "repartition", source = "repartition")
    })
    Seance seanceDTOToSeance(SeanceDTO seanceDTO);
}
