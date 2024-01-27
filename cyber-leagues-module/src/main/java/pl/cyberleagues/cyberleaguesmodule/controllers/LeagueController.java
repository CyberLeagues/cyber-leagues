package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Match;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.LeagueService;
import pl.cyberleagues.cyberleaguesmodule.services.MatchService;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/league")
public class LeagueController {


    private final LeagueService leagueService;

    private final MatchService matchService;

    private final UserService userService;

    //,@RequestParam(value = "game") String leagueGame
    @GetMapping("/all")
    public String getLeaguesByGame(Model model)
    {
        model.addAttribute("leagues", leagueService.getAllAvailableLeagues());
        return "leagueTemplates/leagues";
    }


    @GetMapping
    public String getLeagueByID(Model model,@RequestParam(value = "leagueId") Long leagueID)
    {
        System.out.println(leagueID);
        model.addAttribute("league", leagueService.getLeagueByID(leagueID));

        return "leagueTemplates/league";
    }

    @GetMapping("/create")
    public String creteFrom(Model model, Principal principal){
        model.addAttribute("principal", principal);
        model.addAttribute("league", new League());
        return "leagueTemplates/create";
    }

    @PostMapping("/create")
    public String creteSubmit(@ModelAttribute("league") League league, Model model, Principal principal){
        model.addAttribute("principal", principal);
        model.addAttribute("league", league);

        User user = userService.getUserByProviderId(principal.getName());
        league = leagueService.createLeague(league, user);

        return "leagueTemplates/manager";
    }












}
