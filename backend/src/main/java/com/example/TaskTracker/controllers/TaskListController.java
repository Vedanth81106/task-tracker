package com.example.TaskTracker.controllers;

import com.example.TaskTracker.domain.dto.TaskListDto;
import com.example.TaskTracker.domain.entities.Task;
import com.example.TaskTracker.domain.entities.TaskList;
import com.example.TaskTracker.mappers.TaskListMapper;
import com.example.TaskTracker.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @GetMapping(path = "{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId){
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto){
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.toTaskList((taskListDto))
        );

        return taskListMapper.toDto(createdTaskList);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id") UUID id,
                                      @RequestBody TaskListDto taskListDto){
        TaskList updatedTaskList = taskListService.updateTaskList(id,taskListMapper.toTaskList(taskListDto));

        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deletTaskList(@PathVariable("task_list_id") UUID id){
        taskListService.deleteTaskList(id);
    }

}
