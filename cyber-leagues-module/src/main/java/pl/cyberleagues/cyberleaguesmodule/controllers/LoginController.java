package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "userTemplates/login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}