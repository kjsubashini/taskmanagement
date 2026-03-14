package com.example.taskmanagement.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto) {

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        Task savedTask = taskService.createTask(task);

        TaskResponseDTO response = new TaskResponseDTO();
        response.setId(savedTask.getId());
        response.setTitle(savedTask.getTitle());
        response.setStatus(savedTask.getStatus().name());

        return response;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }
}
