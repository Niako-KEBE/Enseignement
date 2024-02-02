package com.uasz.enseign.serviceImpl.Maquette;

import com.uasz.enseign.dto.Maquette.RoleDto;
import com.uasz.enseign.mappers.Maquette.RoleMapper;
import com.uasz.enseign.model.Maquette.Role;
import com.uasz.enseign.repository.Maquette.RoleRepository;
import com.uasz.enseign.services.Maquette.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }
    @Override
    public Role addRole(RoleDto roleDto) {
        Role role = roleMapper.roleDtoToRole(roleDto);
        roleRepository.save(role);
        return role;
    }

    @Override
    public void deleteRole(Integer integer) {
        roleRepository.deleteById(Long.valueOf(integer));
    }

    @Override
    public List<Role> getAllRole() {
        return StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleByName(String roleName) {
        Role role = roleRepository.findByNom(roleName);
        return roleMapper.roleToRoleDto(role);
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findByid(roleId);
    }
}
