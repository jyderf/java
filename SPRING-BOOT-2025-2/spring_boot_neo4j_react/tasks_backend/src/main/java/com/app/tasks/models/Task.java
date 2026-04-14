package com.app.tasks.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Task")
public class Task {

    @Id
    private String id;

    private String title;

    private String priority;

    public Task() {}

    public Task(String id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
