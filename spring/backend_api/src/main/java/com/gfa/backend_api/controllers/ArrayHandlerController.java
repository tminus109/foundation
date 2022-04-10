package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.ArrayHandlerInput;
import com.gfa.backend_api.models.ArrayHandlerOutput;
import com.gfa.backend_api.models.Error;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayHandlerController {
    private final LogService logService;

    @Autowired
    public ArrayHandlerController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/arrays")
    public ResponseEntity<?> handleArray(@RequestBody ArrayHandlerInput input) {
        logService.newLogEntry("/arrays", input.toString());
        if (input.getWhat() == null || input.getNumbers() == null) {
            return ResponseEntity.status(400).body(new Error("Please provide what to do with the numbers!"));
        } else {
            return ResponseEntity.status(200).body(new ArrayHandlerOutput(input));
        }
    }
}
