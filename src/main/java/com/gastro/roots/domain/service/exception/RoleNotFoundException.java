package com.gastro.roots.domain.service.exception;

public class RoleNotFoundException extends EntityNotFoundException {

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(Long id) {
        this(String.format("Role with id [%d], was not found", id));
    }

}
