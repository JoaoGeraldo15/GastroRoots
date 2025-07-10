package com.gastro.roots.api.exceptionHandler;

import com.gastro.roots.domain.service.exception.EntityInUseExeception;
import com.gastro.roots.domain.service.exception.EntityNotFoundException;
import com.gastro.roots.domain.service.exception.InvalidBusinessOperationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, ServletWebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiError body = ApiError.builder()
                .status(status.value())
                .title("Entity Not Found")
                .detail(ex.getMessage())
                .path(request.getRequest().getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(InvalidBusinessOperationException.class)
    public ResponseEntity<?> handleInvalidBusinessOperationException(InvalidBusinessOperationException ex, ServletWebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError body = ApiError.builder()
                .status(status.value())
                .title("Business Rule Violation")
                .detail(ex.getMessage())
                .path(request.getRequest().getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityInUseExeception.class)
    public ResponseEntity<?> handleEntityInUseExeception(EntityInUseExeception ex, ServletWebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ApiError body = ApiError.builder()
                .status(status.value())
                .title("Entity In Use")
                .detail(ex.getMessage())
                .path(request.getRequest().getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {

        String path = "";
        if (request instanceof ServletWebRequest servletWebRequest) {
            path = servletWebRequest.getRequest().getRequestURI();
        }

        List<ApiError.Field> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> ApiError.Field.builder()
                        .name(fieldError.getField())
                        .userMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        ApiError body = ApiError.builder()
                .status(status.value())
                .title("Invalid Data")
                .detail("One or more fields are invalid. Please correct them and try again")
                .path(path)
                .timestamp(LocalDateTime.now())
                .fields(erros)
                .build();

        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode status, WebRequest request) {
        String path = "";
        if (request instanceof ServletWebRequest servletWebRequest) {
            path = servletWebRequest.getRequest().getRequestURI();
        }

        if (body == null) {
            body = ApiError.builder()
                    .status(status.value())
                    .title(((HttpStatus) status).getReasonPhrase())
                    .path(path)
                    .timestamp(LocalDateTime.now())
                    .build();

        } else if (body instanceof String) {
            body = ApiError.builder()
                    .status(status.value())
                    .title((String) body)
                    .path(path)
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
