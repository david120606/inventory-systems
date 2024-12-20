package com.dsa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Clase de respuesta estandarizada
    public static class ErrorResponse {
        private List<String> message;
        private boolean error;

        public ErrorResponse(List<String> message, boolean error) {
            this.message = message;
            this.error = error;
        }

        public List<String> getMessage() {
            return message;
        }

        public void setMessage(List<String> message) {
            this.message = message;
        }

        public boolean isError() {
            return error;
        }

        public void setError(boolean error) {
            this.error = error;
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        ErrorResponse response = new ErrorResponse(errors, true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalExceptions(Exception ex) {
        List<String> errors = new ArrayList<>();
        errors.add("Ocurrió un error inesperado. Inténtalo más tarde.");
        ErrorResponse response = new ErrorResponse(errors, true);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessExceptions(BusinessException ex) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ErrorResponse response = new ErrorResponse(errors, true);
        return ResponseEntity.status(ex.getStatus()).body(response);
    }


}
