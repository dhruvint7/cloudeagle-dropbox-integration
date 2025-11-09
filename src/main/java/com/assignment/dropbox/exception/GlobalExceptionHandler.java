package com.assignment.dropbox.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles Dropbox-specific API errors propagated from Feign.
     */
    @ExceptionHandler(DropboxApiException.class)
    public ResponseEntity<Map<String, Object>> handleDropboxApiError(DropboxApiException ex) {
        log.error("Dropbox API Error ({}): {}", ex.getStatus(), ex.getRawBody());
        return ResponseEntity
                .status(ex.getStatus())
                .body(Map.of(
                        "error", "Dropbox API failure",
                        "status", ex.getStatus(),
                        "details", ex.getRawBody()
                ));
    }

    /**
     * Handles any unexpected internal errors.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralError(Exception ex) {
        log.error("Unexpected server error: {}", ex.getMessage(), ex);
        return ResponseEntity
                .internalServerError()
                .body(Map.of(
                        "error", "Internal Server Error",
                        "message", ex.getMessage()
                ));
    }
}
