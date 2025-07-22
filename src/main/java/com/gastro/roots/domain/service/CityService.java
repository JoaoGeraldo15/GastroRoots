package com.gastro.roots.domain.service;

import com.gastro.roots.domain.dto.CityDTO;

import java.util.List;

public interface CityService {

    /**
     * Retrieves a list of all cities associated with the given state ID.
     *
     * @param stateId the ID of state to filter the cities
     * @return a list of CityDTO objects belonging to the specified state
     */
    List<CityDTO> list(Long stateId);

    /**
     * Retrieves a list of cities for the given state whose names start with the specified prefix.
     *
     * @param stateId the ID of the state to search within
     * @param name the prefix used to filter city names (case-insensitive)
     * @return a list of CityDTO objects matching the filter criteria
     */
    List<CityDTO> listByName(Long stateId, String name);
}
