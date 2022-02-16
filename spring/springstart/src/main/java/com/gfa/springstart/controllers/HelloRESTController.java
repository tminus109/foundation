package com.gfa.springstart.controllers;

import com.gfa.springstart.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {
    AtomicLong atomicLong = new AtomicLong(0);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam() String name) {
        return new Greeting(atomicLong.incrementAndGet(), "Hello, " + name + "!");
    }
}
