package com.gfa.todo_app;

import com.gfa.todo_app.models.Todo;
import com.gfa.todo_app.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoAppApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("Start the day"));
        todoRepository.save(new Todo("Finish H2 workshop"));
        todoRepository.save(new Todo("Finish JPA workshop"));
        todoRepository.save(new Todo("Create a CRUD project"));
    }
}
