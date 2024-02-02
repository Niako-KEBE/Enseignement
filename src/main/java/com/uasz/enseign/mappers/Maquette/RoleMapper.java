package com.uasz.enseign.mappers.Maquette;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.model.Maquette.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    // Convertit une entité Role en DTO RoleDto
    @Mapping(target = "utilisateurs", ignore = true) // Ignorer la relation inverse pour éviter une boucle infinie
    RoleDto roleToRoleDto(Role role);

    // Convertit un DTO RoleDto en entité Role
    Role roleDtoToRole(RoleDto roleDto);
}
