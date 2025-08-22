package com.example.TaskTracker.controllers;

import com.example.TaskTracker.domain.dto.TaskDto;
import com.example.TaskTracker.domain.entities.Task;
import com.example.TaskTracker.mappers.TaskListMapper;
import com.example.TaskTracker.mappers.TaskMapper;
import com.example.TaskTracker.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/task-lists/{task-list-id}/tasks")
public class TasksController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TasksController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasksInTaskList(@PathVariable("task-list-id") UUID taskListId){
        return taskService.listTasksInTaskList(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @GetMapping("/{task-id}")
    public Optional<TaskDto> getTask(
            @PathVariable("task-list-id") UUID taskListId,
            @PathVariable("task-id") UUID taskId
    ){
        return taskService.getTask(taskListId,taskId).map(taskMapper::toDto);
    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task-list-id") UUID taskListId,
                              @RequestBody TaskDto taskDto){

        Task createdTask = taskService.createTask(taskListId,taskMapper.toTask(taskDto));

        return taskMapper.toDto(createdTask);
    }

    @PutMapping(path = "/{task-id}")
    public TaskDto updateTask(@PathVariable("task-list-id") UUID taskListId,
                              @PathVariable("task-id") UUID taskId,
                              @RequestBody TaskDto taskDto){
        Task updatedTask = taskService.updateTask(taskListId,taskId,taskMapper.toTask(taskDto));

        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping(path = "/{task-id}")
    public void deleteTask(
            @PathVariable("task-list-id") UUID taskListId,
            @PathVariable("task-id") UUID taskId
    ){
        taskService.deleteTask(taskListId,taskId);
    }
}
