package com.gastro.roots.api.controller;

import com.gastro.roots.api.model.input.KitchenInput;
import com.gastro.roots.domain.dto.KitchenDTO;
import com.gastro.roots.domain.service.KitchenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("kitchens")
@RequiredArgsConstructor
public class KitchenController {

    private final KitchenService service;

    @PostMapping
    public ResponseEntity<KitchenDTO> create(@RequestBody @Valid KitchenInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(input));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitchenDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<KitchenDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KitchenDTO> update(@PathVariable Long id, @RequestBody KitchenInput input) {
        return ResponseEntity.ok().body(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
