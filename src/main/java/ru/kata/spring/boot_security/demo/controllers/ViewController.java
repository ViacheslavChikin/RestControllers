package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/admin")
    public String showAllUsers() {
        return "admin";
    }

    @GetMapping("/user")
    public String showTheUser() {
        return "user";
    }
}
