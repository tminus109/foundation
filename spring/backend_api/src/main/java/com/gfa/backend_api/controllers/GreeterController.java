package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Error;
import com.gfa.backend_api.models.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

    @GetMapping("/greeter")
    public ResponseEntity<?> greet(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String title) {
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
