package com.example.TaskTracker.domain.dto;

import com.example.TaskTracker.domain.entities.TaskPriority;
import com.example.TaskTracker.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(UUID id,
                      String title,
                      String description,
                      LocalDateTime dueDate,
                      TaskPriority priority,
                      TaskStatus status) {
}
