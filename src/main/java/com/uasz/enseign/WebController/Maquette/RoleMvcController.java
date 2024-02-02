package com.uasz.enseign.WebController.Maquette;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.model.Maquette.Role;
import com.uasz.enseign.services.Maquette.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@Controller
@RequestMapping("/roles")
public class RoleMvcController {

    private final RoleService roleService;

    @Autowired
    public RoleMvcController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllRoles(Model model) {
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "roleList"; // le nom de la vue, à définir dans vos configurations
    }

    @GetMapping("/{id}")
    public String getRoleById(@PathVariable Long id, Model model) {
        Role role = roleService.getRoleById(id);
        if (role != null) {
            model.addAttribute("role", role);
            return "roleDetails"; // le nom de la vue, à définir dans vos configurations
        } else {
            return "notFound"; // le nom de la vue pour les ressources non trouvées
        }
    }

    @PostMapping
    public ResponseEntity<String> addRole(@ModelAttribute @Validated RoleDto roleDto) {
        RoleDto role = roleService.getRoleByName(roleDto.getNom());
        if (role != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role already exists"); // Le rôle existe déjà
        }

        Role newRole = roleService.addRole(roleService.getRoleByName(roleDto.getNom()));
        RoleDto createdRoleDto = roleService.getRoleByName(newRole.getNom());
        return ResponseEntity.status(HttpStatus.CREATED).body("redirect:/roles/" + createdRoleDto.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRole(@PathVariable Long id, @ModelAttribute @Validated Role role) {
        Role updatedRole = roleService.getRoleById(id);
        if (updatedRole == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }

        updatedRole.setNom(role.getNom());
        updatedRole.setDescription(role.getDescription());

        roleService.update(updatedRole);
        return ResponseEntity.ok("redirect:/roles/" + updatedRole.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }

        roleService.deleteRole(Math.toIntExact(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("redirect:/roles");
    }
}
