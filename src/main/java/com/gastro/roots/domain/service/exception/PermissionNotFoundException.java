package com.gastro.roots.domain.service.exception;

public class PermissionNotFoundException extends EntityNotFoundException {
    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(Long id) {
        this(String.format("Permission with id [%d], was not found", id));
    }
}
