package com.gastro.roots.api.controller;

import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles/{roleId}/permissions")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RoleService service;

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> listPermissionsByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(service.listPermissionsByRoleId(roleId));
    }

    @PutMapping("/{permissionId}")
    public ResponseEntity<Void> addPermissionToRole(@PathVariable Long roleId, @PathVariable Long permissionId) {
        service.addPermissionToRole(roleId, permissionId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<Void> removePermissionFromRole(@PathVariable Long roleId, @PathVariable Long permissionId) {
        service.removePermissionFromRole(roleId, permissionId);
        return ResponseEntity.noContent().build();
    }
}
