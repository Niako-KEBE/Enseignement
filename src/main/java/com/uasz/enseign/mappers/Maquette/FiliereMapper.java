package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.FiliereDTO;
import com.uasz.enseign.model.Maquette.Filiere;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FiliereMapper {
    FiliereMapper INSTANCE = Mappers.getMapper(FiliereMapper.class);

    @Mappings({
            @Mapping(source = "formations", target = "formations")
    })
    FiliereDTO filiereToFiliereDTO(Filiere filiere);

    @Mappings({
            @Mapping(source = "formations", target = "formations")
    })
    Filiere filiereDTOToFiliere(FiliereDTO filiereDTO);

    List<FiliereDTO> filiereListToFiliereDTOList(List<Filiere> filiereList);
}

