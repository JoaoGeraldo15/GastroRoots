package com.gastro.roots.domain.service.impl;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.RestaurantDTO;
import com.gastro.roots.domain.entity.Kitchen;
import com.gastro.roots.domain.entity.Restaurant;
import com.gastro.roots.domain.mapper.RestaurantMapper;
import com.gastro.roots.domain.repository.RestaurantRepository;
import com.gastro.roots.domain.service.KitchenService;
import com.gastro.roots.domain.service.RestaurantService;
import com.gastro.roots.domain.service.exception.RestaurantNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMapper mapper;
    private final KitchenService kitchenService;


    @Override
    @Transactional
    public RestaurantDTO create(RestaurantInput input) {
        Restaurant entity = mapper.toEntity(input);

        Kitchen kitchen = kitchenService.findEntityOrThrow(input.getKitchenId());
        entity.setKitchen(kitchen);

        final Restaurant finalEntity = entity;
        entity.getAddresses().forEach(a -> a.setRestaurant(finalEntity));

        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public RestaurantDTO findById(Long id) {
        return mapper.toDTO(findEntityOrThrow(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RestaurantSummaryDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toSummaryDTO);
    }

    @Override
    @Transactional
    public RestaurantDTO update(Long id, RestaurantInput input) {

        Restaurant entity = findEntityOrThrow(id);
        mapper.updateEntityFromInput(entity, input);

        final Restaurant finalEntity = entity;
        entity.getAddresses().forEach(a -> a.setRestaurant(finalEntity));

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Restaurant entity = findEntityOrThrow(id);
        repository.delete(entity);
    }

    private Restaurant findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }
}
