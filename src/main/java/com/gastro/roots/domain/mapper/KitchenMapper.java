package com.gastro.roots.domain.mapper;

import com.gastro.roots.api.model.input.KitchenInput;
import com.gastro.roots.domain.dto.KitchenDTO;
import com.gastro.roots.domain.entity.Kitchen;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface KitchenMapper {

    Kitchen toEntity(KitchenInput input);

    KitchenDTO toDTO(Kitchen entity);

    void updateEntityFromInput(@MappingTarget Kitchen entity, KitchenInput input);

}
