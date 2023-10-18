package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/add")
    public Float add(
            @RequestParam(value = "a", defaultValue = "0") Float a,
            @RequestParam(value = "b", defaultValue = "0") Float b
    ) {
        return a + b;
    }
}
