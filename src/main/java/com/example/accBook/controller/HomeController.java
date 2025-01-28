package com.example.accBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String redirectToWelcome() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "index";
    }
}
