package org.example.taskmanagement2.dto.responseDto;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    LocalDateTime timestamp;
    int statusCode ;
    String error ;
    String message;
    String path ;

    public ErrorResponseDto(LocalDateTime timestamp, int statusCode, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
