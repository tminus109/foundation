package com.gfa.using_dependencies.green_fox_class_app.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class StudentService {
    private final List<String> names;

    public StudentService() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    public List<String> findAll() {
        return names;
    }

    public void save(String student) {
        names.add(student);
    }

    public int count() {
        return names.size();
    }

    public String check(String name) {
        if (names.contains(name)) {
            return name + " is in the list.";
        } else {
            return name + " is not in the list.";
        }
    }
}
