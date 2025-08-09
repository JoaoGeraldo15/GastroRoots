package com.gastro.roots.api.controller;

import com.gastro.roots.api.model.RoleInput;
import com.gastro.roots.domain.dto.RoleDTO;
import com.gastro.roots.domain.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping
    public ResponseEntity<RoleDTO> create(@RequestBody @Valid RoleInput roleInput) {
        return new ResponseEntity<RoleDTO>(service.create(roleInput), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> create(@PathVariable Long id, @RequestBody @Valid RoleInput roleInput) {
        return new ResponseEntity<RoleDTO>(service.update(roleInput, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
