package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cyberleagues.cyberleaguesmodule.dto.MatchFormDto;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.LeagueService;
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
    private final LeagueService leagueService;

    @GetMapping("/create")
    public String creteFrom(Model model, @RequestParam(value = "leagueId") Long leagueId){
        List<Team> teams = teamService.getAll();
        League league = leagueService.getLeagueByID(leagueId);

        model.addAttribute("teams", teams);
        model.addAttribute("league", league);
        model.addAttribute("matchDto", new MatchFormDto());
        model.addAttribute("match", new Match());

        return "matchTemplates/create";
    }

    @PostMapping("/create")
    public String creteSubmit(@ModelAttribute("match") Match match,
                              @ModelAttribute("matchDto") MatchFormDto matchFormDto,
                              @RequestParam(value = "leagueId") Long leagueId,
                              Model model){

        League league = leagueService.getLeagueByID(leagueId);
        matchService.createMatch(match, league, matchFormDto);
        model.addAttribute("league", league);

        return "matchTemplates/manager";
    }
}
