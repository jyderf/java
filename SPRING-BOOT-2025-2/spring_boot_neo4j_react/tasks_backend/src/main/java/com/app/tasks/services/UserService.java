package com.app.tasks.services;

import com.app.tasks.models.Task;
import com.app.tasks.models.User;
import com.app.tasks.repositories.TaskRepository;
import com.app.tasks.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    // Obtener todos los usuarios
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuario por ID
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    // Crear usuario
    public User saveUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        return userRepository.save(user);
    }

    // Actualizar usuario
    public User updateUser(String id, User userDetails) {
        return userRepository.findById(id).map(existing -> {
            existing.setName(userDetails.getName());
            return userRepository.save(existing);
        }).orElse(null);
    }

    // Eliminar usuario
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Asignar una tarea a un usuario (crea relación HAS_TASK)
    public User assignTaskToUser(String userId, String taskId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Task> taskOpt = taskRepository.findById(taskId);

        if (userOpt.isPresent() && taskOpt.isPresent()) {
            User user = userOpt.get();
            Task task = taskOpt.get();

            List<Task> tasks = user.getTasks();
            if (tasks == null) tasks = new ArrayList<>();

            // Evitar duplicados
            boolean exists = tasks.stream().anyMatch(t -> t.getId().equals(taskId));
            if (!exists) {
                tasks.add(task);
            }

            user.setTasks(tasks);
            return userRepository.save(user); // Neo4j crea la relación
        }
        return null;
    }
}
