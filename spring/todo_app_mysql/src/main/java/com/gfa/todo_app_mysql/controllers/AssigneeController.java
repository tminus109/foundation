package com.gfa.todo_app_mysql.controllers;

import com.gfa.todo_app_mysql.models.Assignee;
import com.gfa.todo_app_mysql.repositories.AssigneeRepository;
import com.gfa.todo_app_mysql.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignees")
public class AssigneeController {
    private final AssigneeRepository assigneeRepository;
    private final AssigneeService assigneeService;

    @Autowired
    public AssigneeController(AssigneeRepository assigneeRepository, AssigneeService assigneeService) {
        this.assigneeRepository = assigneeRepository;
        this.assigneeService = assigneeService;
    }

    @GetMapping("/")
    public String showAssignees(Model model) {
        model.addAttribute("assignees", assigneeRepository.findByOrderByNameAsc());
        return "assignees";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name,
                         Model model) {
        model.addAttribute("assignees", assigneeService.getAssigneesByName(name));
        return "assignees";
    }

    @GetMapping("/add")
    public String showAddNewAssignee(Model model) {
        model.addAttribute("assignee", new Assignee());
        return "add_new_assignee";
    }

    @PostMapping("/add")
    public String addNewAssignee(@ModelAttribute Assignee assignee) {
        assigneeRepository.save(assignee);
        return "redirect:/assignees/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssignee(@PathVariable long id) {
        assigneeService.deleteAssignee(id);
        return "redirect:/assignees/";
    }

    @GetMapping("edit/{id}")
    public String showEditAssignee(@PathVariable long id,
                                   Model model) {
        model.addAttribute("assignee", assigneeRepository.findById(id));
        return "edit_assignee";
    }

    @PostMapping("/edit/{id}")
    public String editAssignee(@PathVariable long id,
                               @ModelAttribute Assignee assignee) {
        assigneeRepository.save(assignee);
        return "redirect:/assignees/";
    }

    @GetMapping("/todos_of_assignee/{id}")
    public String showTodosOfAssignee(@PathVariable long id,
                                      Model model) {
        assigneeRepository.findById(id).ifPresent(a -> model.addAttribute("assignee", a));
        return "todos_of_assignee";
    }
}
