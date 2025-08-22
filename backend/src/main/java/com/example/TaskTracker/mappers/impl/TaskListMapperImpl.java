package com.example.TaskTracker.mappers.impl;

import com.example.TaskTracker.domain.dto.TaskListDto;
import com.example.TaskTracker.domain.entities.Task;
import com.example.TaskTracker.domain.entities.TaskList;
import com.example.TaskTracker.domain.entities.TaskStatus;
import com.example.TaskTracker.mappers.TaskListMapper;
import com.example.TaskTracker.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList toTaskList(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.taskDtos())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toTask)
                                .toList()
                        ).orElse(List.of()),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        List<Task> tasks = Optional.ofNullable(taskList.getTasks()).orElse(List.of());
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                tasks.size(),
                calculateTaskListProgress(taskList.getTasks()),
                tasks.stream()
                        .map(taskMapper::toDto)
                        .toList()
        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }

        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) closedTaskCount / tasks.size();
    }

}
