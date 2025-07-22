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
     * @param externalId the ID of the restaurant
     * @return the corresponding RestaurantDTO
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    RestaurantDTO findById(Long externalId);

    /**
     * Restrieves a list of payment form according the restaurant ID.
     *
     * @param externalId the ID of the restaurant to update
     * @return The paymant Forms associated with a restaurant
     */
    Set<PaymentFormDTO> listPaymentForms(Long externalId);

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
     * @param externalId the ID of the restaurant to update
     * @param input the RestaurantInput containing the updated data
     * @return the updated RestaurantDTO
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    RestaurantDTO update(Long externalId, @Valid RestaurantInput input);

    /**
     * Activates the restaurant with the given ID.
     *
     * @param externalId the ID of the restaurant to activate
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void activate(Long externalId);

    /**
     * Deactivates the restaurant with the given ID.
     *
     * @param externalId the ID of the restaurant to deactivate
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void deactivate(Long externalId);

    /**
     * Deletes a Restaurant by its ID.
     *
     * @param externalId the ID of the Restaurant to delete
     * @throws RestaurantNotFoundException if no restaurant is found with the given ID
     */
    void delete(Long externalId);

    /**
     * Adds a payment form to the specified restaurant.
     *
     * @param externalId the ID of the restaurant to which the payment form will be added
     * @param paymentFormId the ID of the payment form to be added
     * @throws PaymentFormNotFoundException if the restaurant is not found
     * @throws PaymentFormNotFoundException if the payment form is not found
     */
    void removePaymentForm(Long externalId, Long paymentFormId);

    /**
     * Removes a payment form from the specified restaurant.
     *
     * @param externalId the ID of the restaurant from which the payment form will be removed
     * @param paymentFormId the ID of the payment form to be removed
     * @throws PaymentFormNotFoundException if the restaurant is not found
     * @throws PaymentFormNotFoundException if the payment form is not found
     */
    void addPaymentForm(Long externalId, Long paymentFormId);

    /**
     * Opens a restaurant with the given externalId
     *
     * @param externalId the ID of the restaurant to open it
     */
    void open(Long externalId);

    /**
     * Closes a restaurant with the given externalId.
     *
     * @param externalId the ID of the restaurant to close it
     */
    void close(Long externalId);
}
