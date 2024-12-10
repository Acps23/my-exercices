package io.codeforall.fanstatics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public ResponseEntity<String> helloWorld(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        return ResponseEntity.ok("Hello, " + name + "!");
    }
}

