package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.cyberleagues.cyberleaguesmodule.services.LigaService;

@Controller
public class MainPageController {

    private final LigaService ligaService;

    @Autowired
    public MainPageController(LigaService ligaService) {
        this.ligaService = ligaService;
    }

    @GetMapping("/main")
    public String getMainPage(Model model)
    {
        model.addAttribute("Ligi",ligaService.getLigaList());
        return "index";
    }






}
