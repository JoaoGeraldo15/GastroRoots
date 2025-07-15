package com.gastro.roots.domain.service.exception;

public class PaymentFormNotFoundException extends EntityNotFoundException {
    public PaymentFormNotFoundException(String message) {
        super(message);
    }

    public PaymentFormNotFoundException(Long id) {
        this(String.format("PaymentForm with id [%d] was not found", id));
    }
}
