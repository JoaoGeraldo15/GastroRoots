package com.gastro.roots.domain.mapper;

import com.gastro.roots.api.model.RoleInput;
import com.gastro.roots.domain.dto.RoleDTO;
import com.gastro.roots.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {


    Role toEntity(RoleInput input);

    RoleDTO toDTO(Role entity);

    void updateEntityFromInput(@MappingTarget Role entity, RoleInput roleInput);
}
