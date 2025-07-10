package com.gastro.roots.domain.service.impl;

import com.gastro.roots.api.model.input.KitchenInput;
import com.gastro.roots.domain.dto.KitchenDTO;
import com.gastro.roots.domain.entity.Kitchen;
import com.gastro.roots.domain.mapper.KitchenMapper;
import com.gastro.roots.domain.repository.KitchenRepository;
import com.gastro.roots.domain.service.KitchenService;
import com.gastro.roots.domain.service.exception.EntityInUseExeception;
import com.gastro.roots.domain.service.exception.KitchenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private static final String KITCHEN = "Kitchen";

    private final KitchenRepository repository;
    private final KitchenMapper mapper;

    @Override
    @Transactional
    public KitchenDTO create(KitchenInput input) {
        Kitchen entity = mapper.toEntity(input);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public KitchenDTO findById(Long id) {
        return mapper.toDTO(findEntityOrThrow(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<KitchenDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    @Transactional
    public KitchenDTO update(Long id, KitchenInput input) {
        Kitchen currentKitchen = findEntityOrThrow(id);
        mapper.updateEntityFromInput(currentKitchen, input);
        return mapper.toDTO(repository.save(currentKitchen));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Kitchen kitchen = findEntityOrThrow(id);

        try {
            repository.delete(kitchen);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseExeception(KITCHEN, id);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public Kitchen findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new KitchenNotFoundException(id));
    }
}