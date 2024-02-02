package com.uasz.enseign.mappers.EmploiDuTemps;

import com.uasz.enseign.dto.EmploiDuTemps.BatimentDTO;
import com.uasz.enseign.dto.EmploiDuTemps.SalleDTO;
import com.uasz.enseign.model.Emploie_Du_Temps.Batiment;
import com.uasz.enseign.model.Emploie_Du_Temps.Salle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalleMapper {
    SalleMapper INSTANCE = Mappers.getMapper(SalleMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "numero", source = "numero"),
            @Mapping(target = "capacity", source = "capacity"),
            @Mapping(target = "batiment", source = "batiment")
    })
    SalleDTO salleToSalleDTO(Salle salle);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "numero", source = "numero"),
            @Mapping(target = "capacity", source = "capacity"),
            @Mapping(target = "batiment", source = "batiment")
    })
    Salle salleDTOToSalle(SalleDTO salleDTO);

    Batiment batimentDTOToBatiment(BatimentDTO batiment);
}
