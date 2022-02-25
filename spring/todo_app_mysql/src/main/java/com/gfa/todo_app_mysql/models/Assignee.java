package com.gfa.todo_app_mysql.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Assignee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "assignee")
    private Set<Todo> todos;

    public Assignee() {
        this.todos = new HashSet<>();
    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
        this.todos = new HashSet<>();
    }
}
