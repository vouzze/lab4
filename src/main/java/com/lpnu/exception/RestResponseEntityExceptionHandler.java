package com.lpnu.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class )
    public ResponseEntity<Object> handleException(final Exception ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class )
    public ResponseEntity<Object> handleServiceException(final ServiceException ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceExceptionDTO(ex));
    }
}
