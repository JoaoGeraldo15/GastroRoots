package com.gastro.roots.domain.service.exception;

public class StateNotFoundException extends EntityNotFoundException {

    public StateNotFoundException(String message) {
        super(message);
    }

    public StateNotFoundException(Long id) {
        this(String.format("State with id [%id], was not found"));
    }
}
