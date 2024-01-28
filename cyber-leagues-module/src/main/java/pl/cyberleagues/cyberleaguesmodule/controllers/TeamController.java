package pl.cyberleagues.cyberleaguesmodule.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        User user ;
        if (principal != null) {
            user = userService.getUserByProviderId(principal.getName());
        }
        else{
            user = null;
        }
            model.addAttribute("team", team);
            model.addAttribute("user", user);
        return "/teamTemplate/team";
    }


}
