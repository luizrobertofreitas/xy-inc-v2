package com.xyinc.v2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/**
 * Home page controller
 * 
 * @author luiz
 */
@Controller
class HomeController {

    /**
     * Index action
     * @param model
     * @return the page reference
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
