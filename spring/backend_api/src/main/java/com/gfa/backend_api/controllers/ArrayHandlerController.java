package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.ArrayHandlerInput;
import com.gfa.backend_api.models.ArrayHandlerOutput;
import com.gfa.backend_api.models.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayHandlerController {

    @PostMapping("/arrays")
    public ResponseEntity<?> handleArray(@RequestBody ArrayHandlerInput input) {
        if (input.getWhat() == null || input.getNumbers() == null) {
            return ResponseEntity.status(400).body(new Error("Please provide what to do with the numbers!"));
        } else {
            return ResponseEntity.status(200).body(new ArrayHandlerOutput(input));
        }
    }
}
