package com.app.tasks.services;

import com.app.tasks.models.User;
import com.app.tasks.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Iterable<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        return repo.findById(id);
    }
}
