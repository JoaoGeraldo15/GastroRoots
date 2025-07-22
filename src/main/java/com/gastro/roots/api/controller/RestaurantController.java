package com.gastro.roots.api.controller;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.RestaurantDTO;
import com.gastro.roots.domain.service.RestaurantService;
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
@RequestMapping("restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;

    @PostMapping
    public ResponseEntity<RestaurantDTO> create(@RequestBody @Valid RestaurantInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(input));
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<RestaurantDTO> findById(@PathVariable Long externalId) {
        return ResponseEntity.ok(service.findById(externalId));
    }

    @GetMapping
    public Page<RestaurantSummaryDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/{externalId}")
    public ResponseEntity<RestaurantDTO> update(@PathVariable Long externalId, @RequestBody @Valid RestaurantInput input) {
        return ResponseEntity.ok(service.update(externalId, input));
    }

    @PutMapping("/{externalId}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long externalId) {
        service.activate(externalId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{externalId}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long externalId) {
        service.deactivate(externalId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{externalId}/open")
    public ResponseEntity<Void> open(@PathVariable Long externalId) {
        service.open(externalId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{externalId}/close")
    public ResponseEntity<Void> close(@PathVariable Long externalId) {
        service.close(externalId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{externalId}")
    public ResponseEntity<Void> delete(@PathVariable Long externalId) {
        service.delete(externalId);
        return ResponseEntity.noContent().build();
    }
}
