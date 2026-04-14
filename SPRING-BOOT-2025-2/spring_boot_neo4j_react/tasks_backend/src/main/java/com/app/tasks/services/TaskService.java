package com.app.tasks.services;

import com.app.tasks.models.Task;
import com.app.tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Obtener todas las tareas
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    // Buscar tarea por ID
    public Optional<Task> findTaskById(String id) {
        return taskRepository.findById(id);
    }

    // Crear tarea
    public Task saveTask(Task task) {
        if (task.getId() == null || task.getId().isEmpty()) {
            task.setId(UUID.randomUUID().toString());
        }
        return taskRepository.save(task);
    }

    // Actualizar tarea
    public Task updateTask(String id, Task taskDetails) {
        return taskRepository.findById(id).map(existing -> {
            existing.setTitle(taskDetails.getTitle());
            existing.setPriority(taskDetails.getPriority());
            return taskRepository.save(existing);
        }).orElse(null);
    }

    // Eliminar tarea
    public boolean deleteTask(String id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
