package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.LogEntries;
import com.gfa.backend_api.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public ResponseEntity<LogEntries> showLogs() {
        return ResponseEntity.status(200).body(new LogEntries(logService.getLogs()));
    }
}
