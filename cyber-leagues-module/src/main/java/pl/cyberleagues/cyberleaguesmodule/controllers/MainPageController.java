package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainPageController {

    @GetMapping("/main")
    public String getMainPage()
    {
        return "index";
    }


    @GetMapping("/info")
    public String getInfo(Principal principal)
    {
        return principal.getName();
    }

}
