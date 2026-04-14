package com.app.tasks.repositories;

import com.app.tasks.models.Task;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TaskRepository extends Neo4jRepository<Task, String> {
}
