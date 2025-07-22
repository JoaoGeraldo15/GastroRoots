package com.gastro.roots.api.controller;

import com.gastro.roots.domain.dto.StateDTO;
import com.gastro.roots.domain.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/states")
public class StateController {

    private final StateService service;

    @GetMapping
    ResponseEntity<List<StateDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}
