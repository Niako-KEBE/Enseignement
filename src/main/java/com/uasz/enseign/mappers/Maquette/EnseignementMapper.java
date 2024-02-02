package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.EnseignementDTO;
import com.uasz.enseign.model.Maquette.Enseignement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EnseignementMapper {
    EnseignementMapper INSTANCE = Mappers.getMapper(EnseignementMapper.class);

    @Mappings({
            @Mapping(source = "classe", target = "classe"),
            @Mapping(source = "groupe", target = "groupe"),
            @Mapping(source = "modules", target = "modules")
    })
    EnseignementDTO enseignementToEnseignementDTO(Enseignement enseignement);

    @Mappings({
            @Mapping(source = "classe", target = "classe"),
            @Mapping(source = "groupe", target = "groupe"),
            @Mapping(source = "modules", target = "modules")
    })
    Enseignement enseignementDTOToEnseignement(EnseignementDTO enseignementDTO);

    List<EnseignementDTO> enseignementListToEnseignementDTOList(List<Enseignement> enseignements);
}
