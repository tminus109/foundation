package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Double;
import com.gfa.backend_api.models.Error;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {
    private final LogService logService;

    @Autowired
    public DoublingController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/doubling")
    public ResponseEntity<?> doubleInput(@RequestParam(required = false) Integer input) {
        logService.newLogEntry("/doubling", "input=" + input);
        if (input == null) {
            return ResponseEntity.status(200).body(new Error("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new Double(input));
        }
    }
}
