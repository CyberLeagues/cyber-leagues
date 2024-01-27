package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.services.LeagueService;
import pl.cyberleagues.cyberleaguesmodule.services.MatchService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LeagueController {


    private final LeagueService leagueService;

    private final MatchService matchService;

    //,@RequestParam(value = "game") String leagueGame
    @GetMapping("/leagues")
    public String getLeaguesByGame(Model model)
    {
        model.addAttribute("leagues", leagueService.getAllAvailableLeagues());
        return "leagueTemplates/leagues";
    }


    @GetMapping("/league")
    public String getLeagueByID(Model model,@RequestParam(value = "leagueId") Long leagueID)
    {
        System.out.println(leagueID);
        model.addAttribute("league", leagueService.getLeagueByID(leagueID));

        return "leagueTemplates/league";
    }














}
