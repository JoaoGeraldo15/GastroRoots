package com.gastro.roots.domain.mapper;

import com.gastro.roots.domain.dto.CityDTO;
import com.gastro.roots.domain.entity.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDTO toDTO(City entity);
    List<CityDTO> toDTO(List<City> entities);
}
