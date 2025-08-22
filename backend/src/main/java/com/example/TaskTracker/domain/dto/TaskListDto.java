package com.example.TaskTracker.domain.dto;

import com.example.TaskTracker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public record TaskListDto(UUID id,
                          String title,
                          String description,
                          Integer count,
                          Double progress,
                          List<TaskDto> taskDtos) {
}
