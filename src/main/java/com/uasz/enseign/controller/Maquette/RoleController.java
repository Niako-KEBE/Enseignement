package com.uasz.enseign.controller.Maquette;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.model.Maquette.Role;
import com.uasz.enseign.services.Maquette.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRole();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        return role != null
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RoleDto> addRole(@RequestBody @Validated RoleDto roleDto) {
        RoleDto role = roleService.getRoleByName(roleDto.getNom());
        if (role != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Le rôle existe déjà
        }

        Role newRole = roleService.addRole(roleService.getRoleByName(roleDto.getNom()));
        RoleDto createdRoleDto = roleService.getRoleByName(newRole.getNom());
        return new ResponseEntity<>(createdRoleDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody @Validated Role role) {
        Role updatedRole = roleService.getRoleById(id);
        if (updatedRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedRole.setNom(role.getNom());
        updatedRole.setDescription(role.getDescription());

        roleService.update(updatedRole);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roleService.deleteRole(Math.toIntExact(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
