package com.app.tasks.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Task")
public class Task {

    @Id
    private String id; // en tu BD es 't1', 't2', etc

    private String title;
    private boolean done;
    private String priority;

    public Task() {}

    public Task(String id, String title, boolean done, String priority) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.priority = priority;
    }

    // GETTERS & SETTERS

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    @Override
    public String toString() {
        return "Task{id='" + id + "', title='" + title + "', done=" + done +
                ", priority='" + priority + "'}";
    }
}
