package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Double;
import com.gfa.backend_api.models.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

    @GetMapping("/doubling")
    public ResponseEntity<?> doubleInput(@RequestParam(required = false) Integer input) {
        if (input == null) {
            return ResponseEntity.status(200).body(new Error("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new Double(input));
        }
    }
}
