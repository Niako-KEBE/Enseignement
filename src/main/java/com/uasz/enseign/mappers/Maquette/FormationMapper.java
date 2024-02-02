package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.FormationDTO;
import com.uasz.enseign.model.Maquette.Formation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FormationMapper {
    FormationMapper INSTANCE = Mappers.getMapper(FormationMapper.class);

    @Mappings({
            @Mapping(source = "filiere", target = "filiere"),
            @Mapping(source = "maquette", target = "maquette"),
            @Mapping(source = "classes", target = "classes"),
            @Mapping(source = "niveau", target = "niveau")
    })
    FormationDTO formationToFormationDTO(Formation formation);

    @Mappings({
            @Mapping(source = "filiere", target = "filiere"),
            @Mapping(source = "maquette", target = "maquette"),
            @Mapping(source = "classes", target = "classes"),
            @Mapping(source = "niveau", target = "niveau")
    })
    Formation formationDTOToFormation(FormationDTO formationDTO);

    List<FormationDTO> formationListToFormationDTOList(List<Formation> formationList);
}


