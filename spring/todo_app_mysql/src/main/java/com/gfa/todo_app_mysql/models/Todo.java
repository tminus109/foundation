package com.gfa.todo_app_mysql.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private boolean urgent;
    private boolean done;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
    }
}
