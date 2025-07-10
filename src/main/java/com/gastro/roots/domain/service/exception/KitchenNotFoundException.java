package com.gastro.roots.domain.service.exception;

public class KitchenNotFoundException extends EntityNotFoundException {

    KitchenNotFoundException(String message) {
        super(message);
    }

    public KitchenNotFoundException(Long id) {
        this(String.format("Kitchen with id [%d], was not found", id));
    }
}
