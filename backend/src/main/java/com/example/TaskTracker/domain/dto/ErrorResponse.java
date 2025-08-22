package com.example.TaskTracker.domain.dto;

public record ErrorResponse(int status,
                            String message,
                            String details) {
}
