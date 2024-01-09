package pl.cyberleagues.cyberleaguesmodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyberleagues.cyberleaguesmodule.services.LigaService;

@Controller
public class LigaController {


    private final LigaService ligaService;

    @Autowired
    public LigaController(LigaService ligaService) {
        this.ligaService = ligaService;
    }

    @GetMapping("/leagues")
    public String getLeagueByGame(Model model,@RequestParam(value = "game") String leagueGame)
    {
        if(leagueGame.equals("All"))
            model.addAttribute("ligi",ligaService.getLigaList());
        else
            model.addAttribute("ligi",ligaService.getLigaByGame(leagueGame));
        return "leagueTemplates/leagues";
    }














}
