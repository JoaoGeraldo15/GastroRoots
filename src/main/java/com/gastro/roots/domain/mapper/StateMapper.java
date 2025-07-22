package com.gastro.roots.domain.mapper;

import com.gastro.roots.domain.dto.StateDTO;
import com.gastro.roots.domain.entity.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateMapper {

    StateDTO toDTO(State entity);
    List<StateDTO> toDTO(List<State> entities);
}
