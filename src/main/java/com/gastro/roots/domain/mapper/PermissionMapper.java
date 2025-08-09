package com.gastro.roots.domain.mapper;

import com.gastro.roots.domain.dto.PermissionDTO;
import com.gastro.roots.domain.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toDTO(Permission entity);
}
