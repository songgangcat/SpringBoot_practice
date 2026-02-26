package com.example.springbootpractice.controller.lab01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/lab01")
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}