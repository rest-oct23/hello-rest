package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "Ola ke ase";
    }

    @GetMapping("/add")
    public Float add(
            @RequestParam(value = "a", defaultValue = "0") Float a,
            @RequestParam(value = "b", defaultValue = "0") Float b
    ) {
        if(a==0) {
            return b;
        }
        if(b==0) {
            return a;
        }
        return a + b;
    }
}
