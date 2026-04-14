package com.app.tasks.controllers;

import com.app.tasks.models.User;
import com.app.tasks.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    // Crear usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    // Asignar tarea a usuario
    @PostMapping("/{userId}/tasks/{taskId}")
    public User assignTask(
            @PathVariable String userId,
            @PathVariable String taskId
    ) {
        return userService.assignTaskToUser(userId, taskId);
    }
}
