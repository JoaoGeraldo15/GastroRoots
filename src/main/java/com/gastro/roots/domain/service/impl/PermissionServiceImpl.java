package com.gastro.roots.domain.service.impl;

import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.entity.Permission;
import com.gastro.roots.domain.mapper.PermissionMapper;
import com.gastro.roots.domain.repository.PermissionRepository;
import com.gastro.roots.domain.service.PermissionService;
import com.gastro.roots.domain.service.exception.PermissionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    private final PermissionMapper mapper;


    @Override
    public List<PermissionDTO> list() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public Permission findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PermissionNotFoundException(id));
    }
}
