package com.gfa.todo_app_mysql.repositories;

import com.gfa.todo_app_mysql.models.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByDoneFalseOrderById();

    List<Todo> findByOrderByIdAsc();
}
