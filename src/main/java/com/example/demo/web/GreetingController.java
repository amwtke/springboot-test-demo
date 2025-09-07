package com.example.demo.web;

import com.example.demo.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/greet")
    public ResponseEntity<String> greet(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(greetingService.greet(name));
    }
}
