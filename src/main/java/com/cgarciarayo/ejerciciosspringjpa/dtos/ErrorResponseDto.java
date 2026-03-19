package com.cgarciarayo.ejerciciosspringjpa.dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represento la estructura de respuesta de error de la API.
 */
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private List<String> errors;

    public ErrorResponseDto(LocalDateTime timestamp, int status, String message, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}