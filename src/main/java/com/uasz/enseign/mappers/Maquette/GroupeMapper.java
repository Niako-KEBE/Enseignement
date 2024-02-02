package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.GroupeDTO;
import com.uasz.enseign.model.Maquette.Groupe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupeMapper {
    GroupeMapper INSTANCE = Mappers.getMapper(GroupeMapper.class);

    @Mappings({
            @Mapping(source = "enseignement", target = "enseignement"),
            @Mapping(source = "classe", target = "classe")
    })
    GroupeDTO groupeToGroupeDTO(Groupe groupe);

    @Mappings({
            @Mapping(source = "enseignement", target = "enseignement"),
            @Mapping(source = "classe", target = "classe")
    })
    Groupe groupeDTOToGroupe(GroupeDTO groupeDTO);

    List<GroupeDTO> groupeListToGroupeDTOList(List<Groupe> groupeList);
}
