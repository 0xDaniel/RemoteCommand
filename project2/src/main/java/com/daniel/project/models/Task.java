package com.daniel.project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;

    private String employeename;

    private String task;

    private String status;


    public Task(String employeename, String task, String status){
        super();
        this.employeename = employeename;
        this.task = task;
        this.status = status;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {this.status = status;}
}
