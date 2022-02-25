package com.gfa.todo_app_mysql.repositories;

import com.gfa.todo_app_mysql.models.Assignee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findByOrderByNameAsc();
}
