package com.app.tasks.controllers;

import com.app.tasks.models.Task;
import com.app.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Task> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }
}
