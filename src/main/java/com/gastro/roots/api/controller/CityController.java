package com.gastro.roots.api.controller;

import com.gastro.roots.domain.dto.CityDTO;
import com.gastro.roots.domain.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService service;

    @GetMapping("/{stateId}")
    public ResponseEntity<List<CityDTO>> listByName(@PathVariable Long stateId, @RequestParam(required = false) String name) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(service.listByName(stateId, name));
        }
        return ResponseEntity.ok(service.list(stateId));
    }
}
