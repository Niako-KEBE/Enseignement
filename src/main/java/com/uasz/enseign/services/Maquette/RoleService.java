package com.uasz.enseign.services.Maquette;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.model.Maquette.Role;

import java.util.List;

public interface RoleService {
    Role addRole(RoleDto role);
    void deleteRole(Integer integer);
    List<Role> getAllRole();
    RoleDto getRoleByName(String roleName);
    void update(Role rol);
    Role getRoleById(Long roleId);
}
