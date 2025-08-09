package com.gastro.roots.domain.dto;

import com.gastro.roots.domain.entity.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RoleDTO {

    private Long id;
    private String name;
    private Set<Permission> permissions = new HashSet<>();

}
