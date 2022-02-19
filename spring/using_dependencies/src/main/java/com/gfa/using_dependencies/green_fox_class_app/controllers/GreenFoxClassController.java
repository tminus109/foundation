package com.gfa.using_dependencies.green_fox_class_app.controllers;

import com.gfa.using_dependencies.green_fox_class_app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreenFoxClassController {
    private final StudentService studentService;

    @Autowired
    public GreenFoxClassController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/gfa")
    public String showIndex(Model model) {
        model.addAttribute("studentCount", studentService.count());
        return "green_fox_class_app/index";
    }

    @GetMapping("/gfa/list")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "green_fox_class_app/student_list";
    }

    @GetMapping("/gfa/add")
    public String showAddNewStudent() {
        return "green_fox_class_app/add_new_student";
    }

    @PostMapping("/gfa/save")
    public String addNewStudent(@RequestParam String name) {
        studentService.save(name);
        return "redirect:/gfa/list";
    }

    @GetMapping("/gfa/check")
    public String showCheckStudent() {
        return "green_fox_class_app/check_student";
    }

    @PostMapping("/gfa/check")
    public String checkStudent(@RequestParam String name, Model model) {
        model.addAttribute("isInList", studentService.check(name));
        return "green_fox_class_app/check_student";
    }
}
