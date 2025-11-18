package com.app.tasks.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("User")
public class User {

    @Id
    private String id;

    private String name;

    @Relationship(type = "ASIGNADO_A", direction = Relationship.Direction.OUTGOING)
    private List<Task> tasks;

    public User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // GETTERS & SETTERS

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "'}";
    }
}
