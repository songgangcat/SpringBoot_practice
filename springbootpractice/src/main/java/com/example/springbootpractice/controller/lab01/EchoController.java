package com.example.springbootpractice.controller.lab01;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController@RequestMapping("/lab01")
public class EchoController {

    @GetMapping("/echo")
    public Map<String, Object> echo(@RequestParam String q) {
        return Map.of("q", q);
    }

    @PostMapping("/echo")
    public Map<String, Object> echoJson(@RequestBody Map<String, Object> body) {
        return body;
    }
}