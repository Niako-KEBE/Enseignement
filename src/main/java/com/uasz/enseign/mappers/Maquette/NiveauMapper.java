package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.NiveauDTO;
import com.uasz.enseign.model.Maquette.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NiveauMapper {
    NiveauMapper INSTANCE = Mappers.getMapper(NiveauMapper.class);

    @Mappings({
            @Mapping(source = "cycle", target = "cycle"),
            @Mapping(source = "formations", target = "formations")
    })
    NiveauDTO niveauToNiveauDTO(Niveau niveau);

    @Mappings({
            @Mapping(source = "cycle", target = "cycle"),
            @Mapping(source = "formations", target = "formations")
    })
    Niveau niveauDTOToNiveau(NiveauDTO niveauDTO);

    List<NiveauDTO> niveauListToNiveauDTOList(List<Niveau> niveauList);
}
