package com.gastro.roots.domain.service.impl;

import com.gastro.roots.api.model.RoleInput;
import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.dto.RoleDTO;
import com.gastro.roots.domain.entity.Permission;
import com.gastro.roots.domain.entity.Role;
import com.gastro.roots.domain.mapper.PermissionMapper;
import com.gastro.roots.domain.mapper.RoleMapper;
import com.gastro.roots.domain.repository.RoleRepository;
import com.gastro.roots.domain.service.PermissionService;
import com.gastro.roots.domain.service.RoleService;
import com.gastro.roots.domain.service.exception.InvalidBusinessOperationException;
import com.gastro.roots.domain.service.exception.PermissionNotFoundException;
import com.gastro.roots.domain.service.exception.RoleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final PermissionService permissionService;
    private final RoleMapper mapper;
    private final PermissionMapper permissionMapper;


    @Override
    @Transactional
    public RoleDTO create(RoleInput roleInput) {
        Role entity = mapper.toEntity(roleInput);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> list() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public RoleDTO update(RoleInput roleInput, Long id) {
        Role entity = findOrThrow(id);
        mapper.updateEntityFromInput(entity, roleInput);
        Role save = repository.save(entity);
        return mapper.toDTO(save);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Role entity = findOrThrow(id);
        repository.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PermissionDTO> listPermissionsByRoleId(Long roleId) {
        Role role = findOrThrow(roleId);
        return role.getPermissions().stream()
                .map(permissionMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public void addPermissionToRole(Long roleId, Long permissionId) {
        Role role = findOrThrow(roleId);
        Permission permission = null;
        try {
            permission = this.permissionService.findOrThrow(permissionId);
        } catch (PermissionNotFoundException ex) {
            throw new InvalidBusinessOperationException(
                    String.format("Cannot associate Permission to Role because Permission with id [%d] does not exist",
                            permissionId));
        }

        role.addPermission(permission);
    }

    @Override
    @Transactional
    public void removePermissionFromRole(Long roleId, Long permissionId) {
        Role role = findOrThrow(roleId);
        Permission permission;
        try {
            permission = this.permissionService.findOrThrow(permissionId);
        } catch (PermissionNotFoundException ex) {
            throw new InvalidBusinessOperationException(
                    String.format("Cannot disassociate Permission to Role because Permission with id [%d] does not exist",
                            permissionId));
        }

        role.removePermission(permission);
    }

    private Role findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }
}
