package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "hello, home";
    }

    @GetMapping("/secured")
    public String secured(Principal principal){
        return principal.getName();
    }
}
