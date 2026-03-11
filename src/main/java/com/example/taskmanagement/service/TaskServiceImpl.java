package com.example.taskmanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.TaskStatus;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.NotificationService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final NotificationService notificationService;

    public TaskServiceImpl(TaskRepository taskRepository,
                           NotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
    }
    @Override
    public Task createTask(@NotNull Task task) {
        task.setStatus(TaskStatus.TODO);

        Task savedTask = taskRepository.save(task);

        notificationService.sendTaskCreatedNotification(savedTask.getTitle());

        return savedTask;
    }
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}