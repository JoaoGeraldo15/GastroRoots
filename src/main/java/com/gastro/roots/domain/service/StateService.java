package com.gastro.roots.domain.service;

import com.gastro.roots.domain.dto.StateDTO;
import com.gastro.roots.domain.entity.State;

import java.util.List;

public interface StateService {

    /**
     * Retrieves a state by an id
     *
     * @param stateId id of the state to search
     * @return State Entity
     */
    State findEntityOrThrow(Long stateId);

    /**
     * List all states registered
     *
     * @return List of StateDTO
     */
    List<StateDTO> list();
}
