package com.gastro.roots.api.controller;

import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService service;

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}
