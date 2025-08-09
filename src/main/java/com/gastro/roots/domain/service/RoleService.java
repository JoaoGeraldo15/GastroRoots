package com.gastro.roots.domain.service;

import com.gastro.roots.api.model.RoleInput;
import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.dto.RoleDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface RoleService {

    /**
     * Creates a new role in the system based on the provided input data
     *
     * @param roleInput The input data containing the details for the new role. Must be valid.
     * @return  The Data Transfer Object (DTO) of the newly created role, including its generated ID.
     */
    RoleDTO create(@Valid RoleInput roleInput);

    /**
     * Retrieves a list of all roles currently available in the system
     *
     * @return A list of RoleDTO objects, each representing a role.
     */
    List<RoleDTO> list();

    /**
     * Updates an existing role with the provided input data
     *
     * @param roleInput The input data containing the update details for the role.
     * @param id
     * @return The Data Transfer Object (DTO) of the updated role.
     */
    RoleDTO update(@Valid RoleInput roleInput, Long id);

    /**
     * Deletes a role from the system based on its unique identifier.
     *
     * @param id The unique identifier (ID) of the role to be deleted.
     */
    void delete(Long id);

    /**
     * Retrieves a list of Permissions associated with the roleId
     *
     * @param roleId The unique identifier of the role
     * @return A list of Permission
     */
    List<PermissionDTO> listPermissionsByRoleId(Long roleId);

    /**
     * Associates an existing permission with an existing role.
     * This method creates a link between a role and a permission, granting the role the specified permission.
     *
     * @param roleId The unique identifier of the role to which the permission will be added.
     * @param permissionId The unique identifier of the permission to be associated with the role.
     */
    void addPermissionToRole(Long roleId, Long permissionId);

    /**
     * Removes an association between a permission and a role.
     * This effectively revokes a specific permission from a role.
     *
     * @param roleId The unique identifier of the role from which the permission will be removed.
     * @param permissionId The unique identifier of the permission to be removed from the role.
     */
    void removePermissionFromRole(Long roleId, Long permissionId);
}
