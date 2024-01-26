package com.eficens.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String showMainPage(Model model) {
        return "home";
    }

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        return "home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home";
    }
}
