package com.app.tasks.controllers;

import com.app.tasks.models.User;
import com.app.tasks.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }
}
