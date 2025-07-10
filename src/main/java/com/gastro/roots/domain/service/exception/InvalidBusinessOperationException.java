package com.gastro.roots.domain.service.exception;

public class InvalidBusinessOperationException extends RuntimeException {
    public InvalidBusinessOperationException(String message) {
        super(message);
    }
}
