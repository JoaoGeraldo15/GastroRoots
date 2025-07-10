package com.gastro.roots.domain.service.exception;

public class RestaurantNotFoundException extends EntityNotFoundException {

    RestaurantNotFoundException(String message) {
        super(message);
    }

    public RestaurantNotFoundException(Long id) {
        this(String.format("Restaurant with id [%d], was not found", id));
    }
}
