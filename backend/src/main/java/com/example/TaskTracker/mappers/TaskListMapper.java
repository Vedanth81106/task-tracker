package com.example.TaskTracker.mappers;

import com.example.TaskTracker.domain.dto.TaskListDto;
import com.example.TaskTracker.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList toTaskList(TaskListDto taskListDto);
    TaskListDto toDto(TaskList TaskList);
}
