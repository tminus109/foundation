package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Error;
import com.gfa.backend_api.models.Greeting;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    private final LogService logService;

    @Autowired
    public GreeterController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/greeter")
    public ResponseEntity<?> greet(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String title) {
        logService.newLogEntry("/greeter", "name=" + name + ", title=" + title);
        if (name == null && title == null) {
            return ResponseEntity.status(400).body(new Error("Please provide a name and a title!"));
        } else if (title == null) {
            return ResponseEntity.status(400).body(new Error("Please provide a title!"));
        } else if (name == null) {
            return ResponseEntity.status(400).body(new Error("Please provide a name!"));
        } else {
            return ResponseEntity.status(200).body(new Greeting(name, title));
        }
    }
}
