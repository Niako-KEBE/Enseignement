package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.UEDTO;
import com.uasz.enseign.model.Maquette.UE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UEMapper {
    UEMapper INSTANCE = Mappers.getMapper(UEMapper.class);

    @Mappings({
            @Mapping(source = "ecs", target = "ecs"),
            @Mapping(source = "modules", target = "modules"),
            @Mapping(source = "utilisateur", target = "utilisateur")
    })
    UEDTO ueToUEDTO(UE ue);

    @Mappings({
            @Mapping(source = "ecs", target = "ecs"),
            @Mapping(source = "modules", target = "modules"),
            @Mapping(source = "utilisateur", target = "utilisateur")
    })
    UE ueDTOToUE(UEDTO ueDTO);
}

