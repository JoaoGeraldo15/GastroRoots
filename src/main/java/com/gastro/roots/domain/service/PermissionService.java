package com.gastro.roots.domain.service;

import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.entity.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * Returns all permissions
     *
     * @return PermissionDTO
     */
    List<PermissionDTO> list();

    /**
     * Returns a Permission based on the id passed.
     *
     * @param id to retrieves the Permission
     * @return Permission
     */
    Permission findOrThrow(Long id);
}
