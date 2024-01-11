package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyberleagues.cyberleaguesmodule.services.LigaService;

@Controller
@RequiredArgsConstructor
public class LigaController {


    private final LigaService ligaService;

    @GetMapping("/leagues")
    public String getLeaguesByGame(Model model,@RequestParam(value = "game") String leagueGame)
    {
        model.addAttribute("ligi",ligaService.getLigaByGameName(leagueGame));
        return "leagueTemplates/leagues";
    }














}
