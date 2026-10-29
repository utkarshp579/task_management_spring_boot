package org.example.taskmanagement2.dto.responseDto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponseDto {
    LocalDateTime timestamp;
    int statusCode ;
    String error ;
    String message ;
    String path ;
    Map<String , String> fieldErrors;

    public ValidationErrorResponseDto(LocalDateTime timestamp, int statusCode, String error, String message, String path, Map<String , String> fieldErrors) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
