package com.app.tasks.controllers;

import com.app.tasks.models.Task;
import com.app.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Obtener todas las tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    // Buscar tarea por ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskService.findTaskById(id);
    }

    // Crear tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    // Actualizar tarea
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    // Eliminar tarea
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable String id) {
        return taskService.deleteTask(id);
    }
}
