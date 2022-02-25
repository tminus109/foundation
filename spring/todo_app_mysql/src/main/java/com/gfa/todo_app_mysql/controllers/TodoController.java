package com.gfa.todo_app_mysql.controllers;

import com.gfa.todo_app_mysql.models.Todo;
import com.gfa.todo_app_mysql.repositories.AssigneeRepository;
import com.gfa.todo_app_mysql.repositories.TodoRepository;
import com.gfa.todo_app_mysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;
    private final TodoService todoService;
    private final AssigneeRepository assigneeRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository, TodoService todoService, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping({"/", "/list"})
    public String showTodos(@RequestParam(required = false) boolean isActive,
                            Model model) {
        if (isActive) {
            model.addAttribute("todos", todoRepository.findByDoneFalseOrderById());
        } else {
            model.addAttribute("todos", todoRepository.findByOrderByIdAsc());
        }
        return "todos";
    }

    @GetMapping("/add")
    public String showAddNewTodo() {
        return "add_new_todo";
    }

    @PostMapping("/add")
    public String addNewTodo(@RequestParam String title) {
        todoRepository.save(new Todo(title));
        return "redirect:/todos/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodo(@PathVariable long id,
                               Model model) {
        todoRepository.findById(id).ifPresent(t -> model.addAttribute("todo", t));
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "edit_todo";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable long id,
                           @ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todos/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam String keyword,
                         Model model) {
        model.addAttribute("todos", todoService.getTodosByKeyword(keyword));
        return "todos";
    }
}
