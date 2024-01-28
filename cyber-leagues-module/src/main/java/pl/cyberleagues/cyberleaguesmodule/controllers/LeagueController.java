package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cyberleagues.cyberleaguesmodule.models.Game;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.LeagueService;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/league")
public class LeagueController {


    private final LeagueService leagueService;

    private final UserService userService;


    @GetMapping("/all")
    public String getLeaguesByGame(Model model)
    {
        model.addAttribute("leagues", leagueService.getAllAvailableLeagues());
        return "leagueTemplates/leagues";
    }


    @GetMapping
    public String getLeagueByID(Model model, @RequestParam(value = "leagueId") Long leagueID)
    {
        model.addAttribute("league", leagueService.getLeagueByID(leagueID));
        return "leagueTemplates/league";
    }

    @GetMapping("/game")
    public String getFilteredLeaguesByGame(Model model, @RequestParam(value = "name") Game game)
    {
        model.addAttribute("leagues", leagueService.getFilteredLeagueByGame(game));
        return "leagueTemplates/leagues";
    }


    @GetMapping("/create")
    public String creteFrom(Model model, Principal principal){
        model.addAttribute("principal", principal);
        model.addAttribute("league", new League());
        return "leagueTemplates/create";
    }

    @PostMapping("/create")
    public String creteSubmit(@ModelAttribute("league") League league, Model model, Principal principal){
        User user = userService.getUserByProviderId(principal.getName());
        leagueService.createLeague(league, user);

        model.addAttribute("ownedLeagues", user.getOwnedLeagues());
        model.addAttribute("principal", principal);
        model.addAttribute("league", league);

        return "leagueTemplates/manager";
    }

    @GetMapping("/matches")
    public String getUserOwnedLeague(Model model, Principal principal, @RequestParam(value = "leagueId") Long leagueId)
    {
        User user = userService.getUserByProviderId(principal.getName());
        League league = leagueService.getLeagueByID(leagueId);

        if (!user.getOwnedLeagues().contains(league)) {
            return "index";
        }

        model.addAttribute("league", league);
        return "matchTemplates/manager";
    }










}
