package com.gastro.roots.domain.service;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.RestaurantDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {

    /**
     * Creates a new Restaurant.
     *
     * @param input the RestaurantInput containing the restaurant data to be created
     * @return the RestaurantDTO created
     */
    RestaurantDTO create(@Valid RestaurantInput input);

    /**
     * Retrieves a restaurant by its ID.
     *
     * @param id the ID of the restaurant
     * @return the corresponding RestaurantDTO
     */
    RestaurantDTO findById(Long id);

    /**
     * Retrieves a paginated list of all restaurants.
     *
     * @param pageable pagination and sorting information
     * @return a page of RestaurantSummaryDTO objects
     */
    Page<RestaurantSummaryDTO> findAll(Pageable pageable);

    /**
     * Updates an existing restaurant.
     *
     * @param id the ID of the restaurant to update
     * @param input the RestaurantInput containing the updated data
     * @return the updated RestaurantDTO
     */
    RestaurantDTO update(Long id, @Valid RestaurantInput input);

    /**
     * Deletes a Restaurant by its ID.
     *
     * @param id the ID of the Restaurant to delete
     */
    void delete(Long id);
}
