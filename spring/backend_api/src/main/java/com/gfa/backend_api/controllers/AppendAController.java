package com.gfa.backend_api.controllers;

import com.gfa.backend_api.models.Appended;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppendAController {

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<?> appendInput(@PathVariable String appendable) {
        if (appendable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.status(200).body(new Appended(appendable));
        }
    }
}
