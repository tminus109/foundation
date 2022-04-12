package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Error;
import com.gfa.backend_api.models.Factorial;
import com.gfa.backend_api.models.Sum;
import com.gfa.backend_api.models.Until;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoUntilController {
    private final LogService logService;

    @Autowired
    public DoUntilController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/dountil/{operation}")
    public ResponseEntity<?> doUntil(@PathVariable String operation,
                                     @RequestBody Until until) {
        logService.newLogEntry("/dountil/{operation}", "operation=" + operation + ", " + until.toString());
        if (operation.equals("sum") || operation.equals("factor")) {
            if (until.getUntil() != 0) {
                if (operation.equals("sum")) {
                    return ResponseEntity.status(200).body(new Sum(until));
                } else {
                    return ResponseEntity.status(200).body(new Factorial(until));
                }
            } else {
                return ResponseEntity.status(400).body(new Error("Please provide a number!"));
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
