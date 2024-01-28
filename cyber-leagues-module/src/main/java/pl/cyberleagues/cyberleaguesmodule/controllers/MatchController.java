package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.MatchService;
import pl.cyberleagues.cyberleaguesmodule.services.TeamService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/match")
@AllArgsConstructor
public class MatchController {

    private final MatchService matchService;
    private final TeamService teamService;

    @GetMapping("/create")
    public String creteFrom(Model model, @ModelAttribute("league") League league){
        List<Team> teams = teamService.getAll();

        model.addAttribute("teams", teams);
        model.addAttribute("league", league);
        model.addAttribute("match", new Match());

        return "matchTemplates/create";
    }

    @PostMapping("/create")
    public String creteSubmit(@ModelAttribute("match") Match match,
                              @ModelAttribute("league") League league,
                              Model model){

        matchService.createMatch(match, league);
        model.addAttribute("league", league);

        return "matchTemplates/manager";
    }
}
