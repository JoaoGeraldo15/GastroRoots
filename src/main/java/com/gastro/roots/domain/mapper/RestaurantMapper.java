package com.gastro.roots.domain.mapper;

import com.gastro.roots.api.model.RestaurantSummaryDTO;
import com.gastro.roots.api.model.input.RestaurantInput;
import com.gastro.roots.domain.dto.RestaurantDTO;
import com.gastro.roots.domain.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface RestaurantMapper {

    Restaurant toEntity(RestaurantInput input);

    RestaurantDTO toDTO(Restaurant entity);

    RestaurantSummaryDTO toSummaryDTO(Restaurant entity);

    void updateEntityFromInput(@MappingTarget Restaurant entity, RestaurantInput input);
}
