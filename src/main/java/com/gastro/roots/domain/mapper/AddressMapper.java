package com.gastro.roots.domain.mapper;

import com.gastro.roots.api.model.input.AddressInput;
import com.gastro.roots.domain.dto.AddressDTO;
import com.gastro.roots.domain.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "cityId", target = "city.id")
    Address toEntity(AddressInput input);

    @Mapping(source = "city.name", target = "cityName")
    AddressDTO toDTO(Address entity);

}
