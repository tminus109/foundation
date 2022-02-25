package com.gfa.todo_app_mysql.services;

import com.gfa.todo_app_mysql.models.Assignee;
import com.gfa.todo_app_mysql.models.Todo;
import com.gfa.todo_app_mysql.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AssigneeService {
    private final AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public List<Assignee> getAssigneesByName(String keyword) {
        List<Assignee> assignees = (List<Assignee>) assigneeRepository.findAll();
        return assignees.stream()
                .filter(a -> a.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void deleteAssignee(long id) {
        Optional<Assignee> assignee = assigneeRepository.findById(id);
        if (assignee.isPresent()) {
            Set<Todo> todos = assignee.get().getTodos();
            for (Todo todo : todos) {
                todo.setAssignee(null);
            }
            assigneeRepository.deleteById(id);
        }
    }
}
