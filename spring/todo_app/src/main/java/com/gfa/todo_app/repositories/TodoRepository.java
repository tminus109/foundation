package com.gfa.todo_app.repositories;

import com.gfa.todo_app.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
