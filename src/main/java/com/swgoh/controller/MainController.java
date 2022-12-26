package com.swgoh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/swgoh")
public class MainController {

    @GetMapping(value="/main")
    public String showLoginPage(ModelMap model) {
        return "main-menu";
    }
}
