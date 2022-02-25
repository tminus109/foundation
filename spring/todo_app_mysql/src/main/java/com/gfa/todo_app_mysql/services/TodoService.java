package com.gfa.todo_app_mysql.services;

import com.gfa.todo_app_mysql.models.Todo;
import com.gfa.todo_app_mysql.repositories.AssigneeRepository;
import com.gfa.todo_app_mysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final AssigneeRepository assigneeRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }

    public List<Todo> getTodosByKeyword(String keyword) {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        return todos.stream()
                .filter(t -> t.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        t.getAssignee() != null && t.getAssignee().getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void deleteTodo(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            if (todo.get().getAssignee() != null) {
                long assigneeId = todo.get().getAssignee().getId();
                assigneeRepository.findById(assigneeId).ifPresent(a -> a.getTodos().remove(todo.get()));
            }
            todoRepository.deleteById(id);
        }
    }
}
