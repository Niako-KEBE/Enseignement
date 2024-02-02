package com.uasz.enseign.mappers.Utilisateur;

import com.uasz.enseign.dto.Utilisateur.UtilisateurDTO;
import com.uasz.enseign.model.Utilisateur.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "role", source = "role"),
            @Mapping(target = "ues", source = "ues")
    })
    UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur utilisateur);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "prenom", source = "prenom"),
            @Mapping(target = "role", source = "role"),
            @Mapping(target = "ues", source = "ues")
    })
    Utilisateur utilisateurDTOToUtilisateur(UtilisateurDTO utilisateurDTO);

    List<UtilisateurDTO> utilisateursToUtilisateurDTOs(List<Utilisateur> utilisateurs);
}
