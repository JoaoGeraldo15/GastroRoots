package com.gastro.roots.domain.service;


import com.gastro.roots.api.model.input.KitchenInput;
import com.gastro.roots.domain.dto.KitchenDTO;
import com.gastro.roots.domain.entity.Kitchen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface KitchenService {

    /**
     * Retrieves a paginated list of all kitchens.
     *
     * @param pageable pagination and sorting information
     * @return a page of KitchenDTO objects
     */
    Page<KitchenDTO> findAll(Pageable pageable);

    /**
     * Retrieves a kitchen by its ID.
     *
     * @param id the ID of the kitchen
     * @return the corresponding KitchenDTO
     */
    KitchenDTO findById(Long id);

    /**
     * Creates a new kitchen.
     *
     * @param input the KitchenInput containing the kitchen data to be created
     * @return the created KitchenDTO
     */
    KitchenDTO create(KitchenInput input);

    /**
     * Updates an existing kitchen.
     *
     * @param id the ID of the kitchen to update
     * @param input the KitchenInput containing the updated data
     * @return the updated KitchenDTO
     */
    KitchenDTO update(Long id, KitchenInput input);

    /**
     * Deletes a kitchen by its ID.
     *
     * @param id the ID of the kitchen to delete
     */
    void delete(Long id);

    /**
     * Returnes Kitchen Entity by id
     *
     * @param id id the ID of the kitchen
     * @return the corresponding Kitchen
     */
    Kitchen findEntityOrThrow(Long id);
}