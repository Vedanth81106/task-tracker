package com.example.TaskTracker.services;

import com.example.TaskTracker.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {

    //GetMappings
    List<TaskList> listTaskLists();
    Optional<TaskList> getTaskList(UUID id);
    //PostMapping
    TaskList createTaskList(TaskList taskList);
    //PutMapping
    TaskList updateTaskList(UUID taskListId, TaskList taskList);
    //DeleteMapping
    void deleteTaskList(UUID taskListId);

}
