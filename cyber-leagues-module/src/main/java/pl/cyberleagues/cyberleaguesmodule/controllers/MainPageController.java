package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/main")
    public String getMainPage()
    {
        return "template";
    }






}
