package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainPageController {


    @GetMapping("/")
    public String getMainPage()
    {
        return "index";
    }




}
