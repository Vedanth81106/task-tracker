package com.example.TaskTracker.mappers;

import com.example.TaskTracker.domain.dto.TaskDto;
import com.example.TaskTracker.domain.entities.Task;

public interface TaskMapper {

    Task toTask(TaskDto taskDto);
    TaskDto toDto(Task task);
}
