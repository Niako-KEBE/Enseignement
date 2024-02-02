package com.uasz.enseign.mappers.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;
import com.uasz.enseign.model.Emploie_Du_Temps.Batiment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BatimentMapper {
    BatimentMapper INSTANCE = Mappers.getMapper(BatimentMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "salles", source = "salles")
    })
    BatimentDTO batimentToBatimentDTO(Batiment batiment);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "salles", source = "salles")
    })
    Batiment batimentDTOToBatiment(BatimentDTO batimentDTO);
}
