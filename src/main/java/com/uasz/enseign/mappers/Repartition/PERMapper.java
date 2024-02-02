package com.uasz.enseign.mappers.Repartition;
import com.uasz.enseign.dto.Repartition.PERDTO;
import com.uasz.enseign.model.Repartition.PER;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PERMapper {
    PERMapper INSTANCE = Mappers.getMapper(PERMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"), // Map common fields directly
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade"),
            @Mapping(target = "matricule", source = "matricule"),
            @Mapping(target = "statut", source = "statut"),
            @Mapping(target = "anciennete", source = "anciennete")
    })
    PERDTO perToPERDTO(PER per);

    @Mappings({
            @Mapping(target = "id", source = "id"), // Map common fields directly
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "grade", source = "grade"),
            @Mapping(target = "matricule", source = "matricule"),
            @Mapping(target = "statut", source = "statut"),
            @Mapping(target = "anciennete", source = "anciennete")
    })
    PER perDTOToPER(PERDTO perDTO);

    void updateEnseignantFromDTO(PERDTO perDTO, PER existingPER);
}
