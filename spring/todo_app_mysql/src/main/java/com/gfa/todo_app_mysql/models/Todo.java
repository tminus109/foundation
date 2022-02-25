package com.gfa.todo_app_mysql.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ManyToOne()
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean urgent;
    private boolean done;

    public Todo() {
        this.dateCreated = LocalDate.now();
    }

    public Todo(String title) {
        this.title = title;
        this.dateCreated = LocalDate.now();
    }

    public Todo(String title, Assignee assignee, LocalDate dueDate, boolean urgent, boolean done) {
        this.title = title;
        this.assignee = assignee;
        this.dateCreated = LocalDate.now();
        this.dueDate = dueDate;
        this.urgent = urgent;
        this.done = done;
    }
}
