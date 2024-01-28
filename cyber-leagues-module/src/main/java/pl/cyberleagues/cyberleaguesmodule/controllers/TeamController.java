package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cyberleagues.cyberleaguesmodule.models.Invitation;
import pl.cyberleagues.cyberleaguesmodule.models.League;
import pl.cyberleagues.cyberleaguesmodule.models.Team;
import pl.cyberleagues.cyberleaguesmodule.models.User;
import pl.cyberleagues.cyberleaguesmodule.services.TeamService;
import pl.cyberleagues.cyberleaguesmodule.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;

    @GetMapping("/{id}")
    public String getTeamById(Model model, Principal principal, @PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        if (principal==null){
            return "/userTemplates/login";
        }
        User user = userService.getUserByProviderId(principal.getName());
        model.addAttribute("team", team);
        model.addAttribute("user", user);
        return "/teamTemplate/team";
    }

    @GetMapping("/create")
    public String creteFrom(Model model){
        model.addAttribute("team", new Team());
        return "teamTemplate/create";
    }

    @PostMapping("/create")
    public String creteSubmit(@ModelAttribute("team") Team team, Model model, Principal principal){
        User user = userService.getUserByProviderId(principal.getName());
        teamService.createTeam(team, user);

        model.addAttribute("ownedLeagues", user.getOwnedLeagues());
        model.addAttribute("team", team);

        return "teamTemplate/manager";
    }

    @PostMapping("/delete")
    public String creteSubmit(@ModelAttribute("user") User notCompleateUser, Model model, Principal principal){
        User user = userService.getUserByProviderId(notCompleateUser.getProviderId());
        teamService.deletePlayer(user);

        if (principal==null){
            return "/userTemplates/login";
        }

        user = userService.getUserByProviderId(principal.getName());
        List <User> users = userService.getAllUsers();

        model.addAttribute("user",user);
        model.addAttribute("invitation",new Invitation());
        model.addAttribute("users",users);

        return "teamTemplate/manageTeam";
    }


    @GetMapping("/manage")
    public String manageTeam(Model model, Principal principal){
        if (principal==null){
            return "/userTemplates/login";
        }
        User user = userService.getUserByProviderId(principal.getName());
        List <User> users = userService.getAllUsers();

        model.addAttribute("user",user);
        model.addAttribute("invitation",new Invitation());
        model.addAttribute("users",users);
        return "teamTemplate/manageTeam";
    }
}
