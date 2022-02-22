package com.gfa.todo_app_mysql.controllers;

import com.gfa.todo_app_mysql.models.Todo;
import com.gfa.todo_app_mysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping({"/", "/list"})
    public String list(@RequestParam(required = false) boolean isActive,
                       Model model) {
        if (isActive) {
            model.addAttribute("todos", todoRepository.findByDoneFalseOrderById());
        } else {
            model.addAttribute("todos", todoRepository.findByOrderByIdAsc());
        }
        return "todo_list";
    }

    @GetMapping("/add")
    public String showAddNewTodo() {
        return "add_new_todo";
    }

    @PostMapping("/add")
    public String addNewTodo(@RequestParam String title) {
        todoRepository.save(new Todo(title));
        return "redirect:/todo/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodo(@PathVariable long id,
                               Model model) {
        model.addAttribute("todo", todoRepository.findById(id));
        return "edit_todo";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable long id,
                           @ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo/list";
    }
}
