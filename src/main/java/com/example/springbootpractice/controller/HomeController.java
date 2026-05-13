package com.example.springbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
    @RequestMapping("/") // 기본으로 index.html을 보여주기
    public String main() {
        return "index";     //templates/index.html

    }
    
}
