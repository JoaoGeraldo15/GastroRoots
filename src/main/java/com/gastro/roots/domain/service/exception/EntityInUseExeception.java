package com.gastro.roots.domain.service.exception;

public class EntityInUseExeception extends RuntimeException {

    public EntityInUseExeception(String message) {
        super(message);
    }

    public EntityInUseExeception(String entity, Long id) {
        this(String.format("%s with id %d cannot be deleted as it is associated with another entity.", entity, id));
    }
}
