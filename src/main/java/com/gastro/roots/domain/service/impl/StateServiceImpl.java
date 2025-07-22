package com.gastro.roots.domain.service.impl;

import com.gastro.roots.domain.dto.StateDTO;
import com.gastro.roots.domain.entity.State;
import com.gastro.roots.domain.mapper.StateMapper;
import com.gastro.roots.domain.repository.StateRepository;
import com.gastro.roots.domain.service.StateService;
import com.gastro.roots.domain.service.exception.StateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository repository;
    private final StateMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public State findEntityOrThrow(Long stateId) {
        return repository.findById(stateId)
                .orElseThrow(() -> new StateNotFoundException(stateId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StateDTO> list() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
