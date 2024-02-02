package com.uasz.enseign.mappers.Maquette;
import com.uasz.enseign.dto.Maquette.ECDTO;
import com.uasz.enseign.model.Maquette.EC;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ECMapper {
    ECMapper INSTANCE = Mappers.getMapper(ECMapper.class);

    @Mappings({
            @Mapping(source = "ue", target = "ue"),
            @Mapping(source = "module", target = "module")
    })
    ECDTO ecToEcDTO(EC ec);

    @Mappings({
            @Mapping(source = "ue", target = "ue"),
            @Mapping(source = "module", target = "module")
    })
    EC ecDTOToEC(ECDTO ecDTO);

    List<ECDTO> ecListToECDTOList(List<EC> ecList);
}
