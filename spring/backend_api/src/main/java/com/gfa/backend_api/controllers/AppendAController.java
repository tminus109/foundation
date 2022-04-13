package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Appended;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppendAController {
    private final LogService logService;

    @Autowired
    public AppendAController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<Appended> appendInput(@PathVariable String appendable) {
        logService.newLogEntry("/appenda/{appendable}", "input=" + appendable);
        if (appendable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.status(200).body(new Appended(appendable));
        }
    }
}
