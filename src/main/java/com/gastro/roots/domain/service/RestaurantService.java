package com.gastro.roots.domain.service;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.PaymentFormDTO;
import com.gastro.roots.domain.dto.RestaurantDTO;
import com.gastro.roots.domain.service.exception.PaymentFormNotFoundException;
import com.gastro.roots.domain.service.exception.RestaurantNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    RestaurantDTO findById(Long id);

    /**
     * Restrieves a list of payment form according the restaurant ID.
     *
     * @param restaurantId the ID of the restaurant to update
     * @return
     */
    Set<PaymentFormDTO> listPaytmentsForm(Long restaurantId);

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
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    RestaurantDTO update(Long id, @Valid RestaurantInput input);

    /**
     * Activates the restaurant with the given ID.
     *
     * @param id the ID of the restaurant to activate
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void activate(Long id);

    /**
     * Deactivates the restaurant with the given ID.
     *
     * @param id the ID of the restaurant to deactivate
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void deactivate(Long id);

    /**
     * Deletes a Restaurant by its ID.
     *
     * @param id the ID of the Restaurant to delete
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void delete(Long id);

    /**
     * Adds a payment form to the specified restaurant.
     *
     * @param restaurantId the ID of the restaurant to which the payment form will be added
     * @param paymentFormId the ID of the payment form to be added
     * @throws PaymentFormNotFoundException if the restaurant is not found
     * @throws PaymentFormNotFoundException if the payment form is not found
     */
    void removePaymentForm(Long restaurantId, Long paymentFormId);

    /**
     * Removes a payment form from the specified restaurant.
     *
     * @param restaurantId the ID of the restaurant from which the payment form will be removed
     * @param paymentFormId the ID of the payment form to be removed
     * @throws PaymentFormNotFoundException if the restaurant is not found
     * @throws PaymentFormNotFoundException if the payment form is not found
     */
    void addPaymentForm(Long restaurantId, Long paymentFormId);
}
