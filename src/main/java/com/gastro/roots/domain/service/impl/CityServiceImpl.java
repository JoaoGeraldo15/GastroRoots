package com.gastro.roots.domain.service.impl;

import com.gastro.roots.domain.dto.CityDTO;
import com.gastro.roots.domain.mapper.CityMapper;
import com.gastro.roots.domain.repository.CityRepository;
import com.gastro.roots.domain.service.CityService;
import com.gastro.roots.domain.service.StateService;
import com.gastro.roots.domain.service.exception.InvalidBusinessOperationException;
import com.gastro.roots.domain.service.exception.StateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CityMapper mapper;

    private final StateService stateService;

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> list(Long stateId) {
        validState(stateId);
        return mapper.toDTO(repository.findAllByStateId(stateId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> listByName(Long stateId, String name) {
        validState(stateId);

        return mapper.toDTO(repository.findByStateIdAndNameContainingIgnoreCase(stateId, name));
    }

    private void validState(Long stateId) {
        try {
            stateService.findEntityOrThrow(stateId);
        } catch (StateNotFoundException ex) {
            throw new InvalidBusinessOperationException("Cannot list the cities: State with ID: %d does not exist.");
        }
    }
}
