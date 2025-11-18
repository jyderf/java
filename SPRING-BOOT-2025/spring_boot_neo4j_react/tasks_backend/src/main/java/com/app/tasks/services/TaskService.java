package com.app.tasks.services;

import com.app.tasks.models.Task;
import com.app.tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Iterable<Task> findAll() {
        return repo.findAll();
    }

    public Optional<Task> findById(String id) {
        return repo.findById(id);
    }
}
