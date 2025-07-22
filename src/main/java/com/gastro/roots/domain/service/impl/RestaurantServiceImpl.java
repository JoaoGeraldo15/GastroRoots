package com.gastro.roots.domain.service.impl;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.PaymentFormDTO;
import com.gastro.roots.domain.dto.RestaurantDTO;
import com.gastro.roots.domain.entity.Kitchen;
import com.gastro.roots.domain.entity.PaymentForm;
import com.gastro.roots.domain.entity.Restaurant;
import com.gastro.roots.domain.mapper.PaymentFormMapper;
import com.gastro.roots.domain.mapper.RestaurantMapper;
import com.gastro.roots.domain.repository.RestaurantRepository;
import com.gastro.roots.domain.service.KitchenService;
import com.gastro.roots.domain.service.PaymentFormService;
import com.gastro.roots.domain.service.RestaurantService;
import com.gastro.roots.domain.service.exception.InvalidBusinessOperationException;
import com.gastro.roots.domain.service.exception.KitchenNotFoundException;
import com.gastro.roots.domain.service.exception.RestaurantNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMapper mapper;
    private final PaymentFormMapper paymentFormMapper;
    private final KitchenService kitchenService;
    private final PaymentFormService paymentFormService;


    @Override
    @Transactional
    public RestaurantDTO create(RestaurantInput input) {
        Restaurant entity = mapper.toEntity(input);
        try {

            Kitchen kitchen = kitchenService.findEntityOrThrow(input.getKitchenId());
            entity.setKitchen(kitchen);

        } catch (KitchenNotFoundException ex) {
            throw new InvalidBusinessOperationException(
                    String.format("Cannot create a Restaurant: Kitchen with ID: %d does not exist.",
                            input.getKitchenId())
            );
        }

        final Restaurant finalEntity = entity;
        entity.getAddresses().forEach(a -> a.setRestaurant(finalEntity));

        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public RestaurantDTO findById(Long externalId) {
        return mapper.toDTO(findEntityOrThrow(externalId));
    }

    @Override
    @Transactional(readOnly = true)
    public Set<PaymentFormDTO> listPaymentForms(Long externalId) {
        return paymentFormMapper.toDTO(findEntityOrThrow(externalId).getPaymentsForm());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RestaurantSummaryDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toSummaryDTO);
    }

    @Override
    @Transactional
    public RestaurantDTO update(Long externalId, RestaurantInput input) {

        Restaurant entity = findEntityOrThrow(externalId);

        try {

            Kitchen kitchen = kitchenService.findEntityOrThrow(input.getKitchenId());
            entity.setKitchen(kitchen);

        } catch (KitchenNotFoundException ex) {
            throw new InvalidBusinessOperationException(
                    String.format("Cannot update a Restaurant: Kitchen with ID: %d does not exist.",
                            input.getKitchenId())
            );
        }

        mapper.updateEntityFromInput(entity, input);

        final Restaurant finalEntity = entity;
        entity.getAddresses().forEach(a -> a.setRestaurant(finalEntity));

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    @Transactional
    public void activate(Long externalId) {
        Restaurant entity = findEntityOrThrow(externalId);
        entity.activate();
    }

    @Override
    @Transactional
    public void deactivate(Long externalId) {
        Restaurant entity = findEntityOrThrow(externalId);
        entity.deactivate();
    }

    @Override
    @Transactional
    public void delete(Long externalId) {
        Restaurant entity = findEntityOrThrow(externalId);
        repository.delete(entity);
    }

    @Override
    @Transactional
    public void removePaymentForm(Long externalId, Long paymentFormId) {
        Restaurant entity = findEntityOrThrow(externalId);
        PaymentForm paymentForm = paymentFormService.findEntityById(paymentFormId);
        entity.getPaymentsForm().remove(paymentForm);
    }

    @Override
    @Transactional
    public void addPaymentForm(Long externalId, Long paymentFormId) {
        Restaurant entity = findEntityOrThrow(externalId);
        PaymentForm paymentForm = paymentFormService.findEntityById(paymentFormId);
        entity.getPaymentsForm().add(paymentForm);
    }

    @Override
    @Transactional
    public void open(Long externalId) {
        Restaurant entity = findEntityOrThrow(externalId);
        entity.open();
    }

    @Override
    @Transactional
    public void close(Long externalId) {
        Restaurant entity = findEntityOrThrow(externalId);
        entity.close();
    }

    private Restaurant findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }
}
